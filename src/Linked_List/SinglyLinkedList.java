package Linked_List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements LinkedListADT<T>, Iterable<T> {
	LinearNode<T> front;
	int count;

	public SinglyLinkedList() {
		front = null;
		count = 0;
	}

	@Override
	public void add(T element) {
		if (element == null)
			throw new IllegalArgumentException("Element cannot be null");

		if (front == null) {
			front = new LinearNode<T>(element, null);
		} else {
			LinearNode<T> rear = getNode(count - 1);
			rear.setNext(new LinearNode<T>(element, null));
		}
		count++;
	}

	@Override
	public void add(int index, T element) {
		if (index < 0 || (index > count - 1 && index != 0))
			throw new IndexOutOfBoundsException("Index out of bounds");
		if (element == null)
			throw new IllegalArgumentException("Element cannot be null");

		if (index == 0) {
			front = new LinearNode<T>(element, front);
		} else {
			LinearNode<T> node_before_new = getNode(index - 1);
			LinearNode<T> new_node = new LinearNode<>(element, node_before_new.getNext());
			node_before_new.setNext(new_node);
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
	public LinearNode<T> getNode(int index) {
		if (isEmpty())
			throw new IllegalStateException("List empty");
		if (index < 0 || (index > count - 1 && index != 0))
			throw new IndexOutOfBoundsException("Index out of bounds");

		LinearNode<T> result = front;
		for (int i = 0; i < index; i++) {
			result = result.getNext();
		}
		return result;
	}

	@Override
	public T remove(int index) {
		if (isEmpty())
			throw new IllegalStateException("List empty");
		if (index < 0 || (index > count - 1 && index != 0))
			throw new IndexOutOfBoundsException("Index out of bounds");

		LinearNode<T> to_remove = null;
		if (index == 0) {
			to_remove = front;
			front = front.getNext();
		} else {
			LinearNode<T> before_to_remove = getNode(index - 1);
			to_remove = before_to_remove.getNext();
			before_to_remove.setNext(to_remove.getNext());
		}
		count--;
		return to_remove.getElement();
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
	public Iterator<T> iterator() {
		return new SinglyLinkedListIterator<T>(front);
	}

	private class SinglyLinkedListIterator<T> implements Iterator<T> {
		private LinearNode<T> node;

		public SinglyLinkedListIterator(LinearNode<T> node) {
			this.node = node;
		}

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			T element = node.getElement();
			node = node.getNext();
			return element;
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (T node : this)
			sb.append(node + "\n");
		return sb.toString();

	}
}
