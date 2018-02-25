package Linked_List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedCircularList<T> implements LinkedListADT<T>, Iterable<T> {
	int count;
	DoubleNode<T> front;

	public DoublyLinkedCircularList() {
		front = null;
		count = 0;
	}

	@Override
	public void add(T element) {
		if (element == null)
			throw new IllegalArgumentException("Element cannot be null");
		if (front == null) {
			addFirst(element);
		} else {
			DoubleNode<T> rear = new DoubleNode<>(element);
			rear.setPrevious(front.getPrevious());
			front.getPrevious().setNext(rear);
			front.setPrevious(rear);
			rear.setNext(front);
			count++;
		}
	}

	@Override
	public void add(int index, T element) {
		if (element == null)
			throw new IllegalArgumentException("Element cannot be null");
		if (index < 0 || (index > count - 1 && index != 0))
			throw new IndexOutOfBoundsException("Index out of bounds");

		if (index == 0) {
			addFirst(element);
		} else {
			DoubleNode<T> previous_node = getNode(index - 1);
			DoubleNode<T> next_node = previous_node.getNext();
			DoubleNode<T> new_node = new DoubleNode<T>(element, previous_node, next_node);
			previous_node.setNext(new_node);
			next_node.setPrevious(new_node);
			count++;
		}
	}

	public void addFirst(T element) {
		if (front == null) {
			front = new DoubleNode<>(element);
			front.setNext(front);
			front.setPrevious(front);
		} else {
			DoubleNode<T> previous_node = front.getPrevious();
			DoubleNode<T> next_node = previous_node.getNext();
			DoubleNode<T> new_node = new DoubleNode<T>(element, previous_node, next_node);
			previous_node.setNext(new_node);
			next_node.setPrevious(new_node);
			front = new_node;
		}
		count++;
	}

	@Override
	public void set(int index, T element) {
		if (element == null)
			throw new IllegalArgumentException("Element cannot be null");

		getNode(index).setElement(element);
	}

	@Override
	public T get(int index) {
		return getNode(index).getElement();
	}

	@Override
	public DoubleNode<T> getNode(int index) {
		if (isEmpty())
			throw new IllegalStateException("List empty");
		if (index < 0 || (index > count - 1 && index != 0))
			throw new IndexOutOfBoundsException("Index out of bounds");

		DoubleNode<T> node = front;
		for (int i = 0; i < index; i++) {
			node = node.getNext();
		}
		return node;
	}

	@Override
	public T remove(int index) {
		if (isEmpty())
			throw new IllegalStateException("List empty");
		if (index < 0 || (index > count - 1 && index != 0))
			throw new IndexOutOfBoundsException("Index out of bounds");

		DoubleNode<T> to_remove = null;
		if (index == 0) {
			to_remove = removeFirst();
		} else if (index == count - 1) {
			to_remove = removeLast();
		} else {
			DoubleNode<T> before_to_remove = getNode(index - 1);
			to_remove = before_to_remove.getNext();
			DoubleNode<T> after_to_remove = to_remove.getNext();
			before_to_remove.setNext(after_to_remove);
			after_to_remove.setPrevious(before_to_remove);
			count--;
		}
		return to_remove.getElement();
	}

	public DoubleNode<T> removeFirst() {
		if (isEmpty())
			throw new IllegalStateException("List empty");
		DoubleNode<T> to_remove = null;
		if (count == 1) {
			to_remove = front;
			front = null;
		} else {
			to_remove = front;
			front.getNext().setPrevious(front.getPrevious());
			front.getPrevious().setNext(front.getNext());
		}
		count--;
		return to_remove;
	}

	public DoubleNode<T> removeLast() {
		if (isEmpty())
			throw new IllegalStateException("List empty");
		DoubleNode<T> to_remove = null;
		if (count == 1) {
			to_remove = front;
			front = null;
		} else {
			to_remove = front.getPrevious();
			to_remove.getPrevious().setNext(front);
			front.setPrevious(to_remove.getPrevious());
		}
		count--;
		return to_remove;
	}

	@Override
	public T removeElement(T element) {
		try {
			return remove(indexOf(element));
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalStateException("Element not found");
		}
	}

	@Override
	public int indexOf(T element) {
		if (isEmpty())
			return -1;

		int index = 0;
		for (T item : this) {
			if (item.equals(element))
				return index;
			index++;
		}
		return -1;
	}

	@Override
	public boolean contains(T element) {
		return indexOf(element) != -1;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (T element : this)
			sb.append(element + "\n");
		return sb.toString();
	}

	public String reversedList() {
		StringBuilder sb = new StringBuilder();
		ReversedDoublyLinkedCircularListIterator<T> ri;
		for (ri = reversedIterator(); ri.hasNext(); ri.next()) {
			sb.append(ri.getElement() + "\n");
		}
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new DoublyLinkedCircularListIterator<T>(front);
	}

	public ReversedDoublyLinkedCircularListIterator<T> reversedIterator() {
		return new ReversedDoublyLinkedCircularListIterator<T>(front);
	}

	private class DoublyLinkedCircularListIterator<T> implements Iterator<T> {
		private DoubleNode<T> node;
		private int i;

		public DoublyLinkedCircularListIterator(DoubleNode<T> node) {
			this.node = node;
			this.i = 0;
		}

		@Override
		public boolean hasNext() {
			return i < count;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T element = node.getElement();
			node = node.getNext();
			i++;
			return element;
		}
	}

	private class ReversedDoublyLinkedCircularListIterator<T> implements Iterator<T> {
		private DoubleNode<T> node;
		private int i;

		public ReversedDoublyLinkedCircularListIterator(DoubleNode<T> node) {
			this.node = node.getPrevious();
			this.i = 0;
		}

		@Override
		public boolean hasNext() {
			return i < count;
		}

		public T getElement() {
			return node.getElement();
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T element = node.getElement();
			node = node.getPrevious();
			i++;
			return element;
		}
	}
}
