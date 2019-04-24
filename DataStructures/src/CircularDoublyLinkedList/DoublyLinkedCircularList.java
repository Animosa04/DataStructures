//package Linked_List.CircularDoublyLinkedList;
//
//import Linked_List.LinkedListADT;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class DoublyLinkedCircularList<T> implements LinkedListADT<T>, Iterable<T> {
//	/**
//	 * reference to the front element of the list
//	 */
//	DoubleNode<T> front;
//	/**
//	 * int representing the number of elements in the list
//	 */
//	int count;
//
//	/**
//	 * Creates an empty doubly linked circular list of a generic type.
//	 */
//	public DoublyLinkedCircularList() {
//		front = null;
//		count = 0;
//	}
//
//	/**
//	 * Adds an element at the end of the list. Null elements are not permitted.
//	 *
//	 * @param element
//	 *            element to be added to the list
//	 * @throws IllegalArgumentException
//	 *             if element is null
//	 */
//	@Override
//	public void addAsFirstElement(T element) {
//		if (element == null)
//			throw new IllegalArgumentException("Element cannot be null");
//		if (front == null) {
//			addFirst(element);
//		} else {
//			DoubleNode<T> rear = new DoubleNode<>(element);
//			rear.setPrevious(front.getPrevious());
//			front.getPrevious().setNext(rear);
//			front.setPrevious(rear);
//			rear.setNext(front);
//			count++;
//		}
//	}
//
//	/**
//	 * Adds an element at the specified index. Null elements are not permitted.
//	 *
//	 * @param index
//	 *            index where the element should be placed
//	 * @param element
//	 *            element to be added to the list
//	 * @throws IndexOutOfBoundsException
//	 *             if the specified index is out of bounds
//	 * @throws IllegalArgumentException
//	 *             if element is null
//	 */
//	@Override
//	public void addAsFirstElement(int index, T element) {
//		if (element == null)
//			throw new IllegalArgumentException("Element cannot be null");
//		if (index < 0 || (index > count - 1 && index != 0))
//			throw new IndexOutOfBoundsException("Index out of bounds");
//
//		if (index == 0) {
//			addFirst(element);
//		} else {
//			DoubleNode<T> previous_node = getNode(index - 1);
//			DoubleNode<T> next_node = previous_node.getNext();
//			DoubleNode<T> new_node = new DoubleNode<T>(element, previous_node, next_node);
//			previous_node.setNext(new_node);
//			next_node.setPrevious(new_node);
//			count++;
//		}
//	}
//
//	/**
//	 * Adds an element at the front of the list. Null elements are not permitted.
//	 *
//	 * @param element
//	 *            element to be added to the list
//	 * @throws IllegalArgumentException
//	 *             if element is null
//	 */
//	public void addFirst(T element) {
//		if (element == null)
//			throw new IllegalArgumentException("Element cannot be null");
//		if (front == null) {
//			front = new DoubleNode<>(element);
//			front.setNext(front);
//			front.setPrevious(front);
//		} else {
//			DoubleNode<T> previous_node = front.getPrevious();
//			DoubleNode<T> next_node = previous_node.getNext();
//			DoubleNode<T> new_node = new DoubleNode<T>(element, previous_node, next_node);
//			previous_node.setNext(new_node);
//			next_node.setPrevious(new_node);
//			front = new_node;
//		}
//		count++;
//	}
//
//	/**
//	 * Sets the element of the node at the specified index. Null elements are not
//	 * permitted.
//	 *
//	 * @param index
//	 *            index of the node whose element is to be set
//	 * @param element
//	 *            element to be set as the node's new element
//	 * @throws IllegalArgumentException
//	 *             if element is null
//	 */
//	@Override
//	public void set(int index, T element) {
//		if (element == null)
//			throw new IllegalArgumentException("Element cannot be null");
//
//		getNode(index).setElement(element);
//	}
//
//	/**
//	 * Returns the element of the node at the specified index.
//	 *
//	 * @param index
//	 *            index of node
//	 * @return element of the node at the specified index
//	 */
//	@Override
//	public T get(int index) {
//		return getNode(index).getElement();
//	}
//
//	/**
//	 * Returns the node at the specified index.
//	 *
//	 * @param index
//	 *            index of node
//	 * @return node at the specified index
//	 * @throws IllegalStateException
//	 *             if the list is empty
//	 * @throws IndexOutOfBoundsException
//	 *             if index is out out bounds
//	 */
//	@Override
//	public DoubleNode<T> getNode(int index) {
//		if (isEmpty())
//			throw new IllegalStateException("List empty");
//		if (index < 0 || (index > count - 1 && index != 0))
//			throw new IndexOutOfBoundsException("Index out of bounds");
//
//		DoubleNode<T> node = front;
//		for (int i = 0; i < index; i++) {
//			node = node.getNext();
//		}
//		return node;
//	}
//
//	/**
//	 * Removes the node at the specified index and returns its element.
//	 *
//	 * @param index
//	 *            index of the node to be removed
//	 * @return element of the removed node
//	 * @throws IllegalStateException
//	 *             if the list is empty
//	 * @throws IndexOutOfBoundsException
//	 *             if index is out of bounds
//	 */
//	@Override
//	public T remove(int index) {
//		if (isEmpty())
//			throw new IllegalStateException("List empty");
//		if (index < 0 || (index > count - 1 && index != 0))
//			throw new IndexOutOfBoundsException("Index out of bounds");
//
//		DoubleNode<T> to_remove = null;
//		if (index == 0) {
//			to_remove = removeFirst();
//		} else if (index == count - 1) {
//			to_remove = removeLast();
//		} else {
//			DoubleNode<T> before_to_remove = getNode(index - 1);
//			to_remove = before_to_remove.getNext();
//			DoubleNode<T> after_to_remove = to_remove.getNext();
//			before_to_remove.setNext(after_to_remove);
//			after_to_remove.setPrevious(before_to_remove);
//			count--;
//		}
//		return to_remove.getElement();
//	}
//
//	/**
//	 * Removes the first node of the list and returns it.
//	 *
//	 * @return removed node
//	 * @throws IllegalStateException
//	 *             if the list is empty
//	 */
//	public DoubleNode<T> removeFirst() {
//		if (isEmpty())
//			throw new IllegalStateException("List empty");
//		DoubleNode<T> to_remove = null;
//		if (count == 1) {
//			to_remove = front;
//			front = null;
//		} else {
//			to_remove = front;
//			front.getNext().setPrevious(front.getPrevious());
//			front.getPrevious().setNext(front.getNext());
//		}
//		count--;
//		return to_remove;
//	}
//
//	/**
//	 * Removes the last node of the list and returns it.
//	 *
//	 * @return removed node
//	 * @throws IllegalStateException
//	 *             if the list is empty
//	 */
//	public DoubleNode<T> removeLast() {
//		if (isEmpty())
//			throw new IllegalStateException("List empty");
//		DoubleNode<T> to_remove = null;
//		if (count == 1) {
//			to_remove = front;
//			front = null;
//		} else {
//			to_remove = front.getPrevious();
//			to_remove.getPrevious().setNext(front);
//			front.setPrevious(to_remove.getPrevious());
//		}
//		count--;
//		return to_remove;
//	}
//
//	/**
//	 * Removes a node with the specified element and returns the element.
//	 *
//	 * @param element
//	 *            to be removed from the list
//	 * @return element removed
//	 * @throws IllegalStateException
//	 *             if the element is not in the list
//	 */
//	@Override
//	public T removeElement(T element) {
//		try {
//			return remove(indexOf(element));
//		} catch (IndexOutOfBoundsException e) {
//			throw new IllegalStateException("Element not found");
//		}
//	}
//
//	/**
//	 * Returns the index of a specified element in the list.
//	 *
//	 * @param element
//	 *            whose index is searched
//	 * @return index of the specified element, -1 if the element is not in the list
//	 */
//	@Override
//	public int indexOf(T element) {
//		if (isEmpty())
//			return -1;
//
//		int index = 0;
//		for (T item : this) {
//			if (item.equals(element))
//				return index;
//			index++;
//		}
//		return -1;
//	}
//
//	/**
//	 * Returns whether the element specified is in the list. If the index of the
//	 * element is not -1, it means that the element is in the list.
//	 *
//	 * @param element
//	 *            element to check if is present in the list
//	 * @return true if the element is in the list
//	 */
//	@Override
//	public boolean contains(T element) {
//		return indexOf(element) != -1;
//	}
//
//	/**
//	 * Returns whether the list is empty or not.
//	 *
//	 * @return true if the size of the list is 0
//	 */
//	@Override
//	public boolean isEmpty() {
//		return count == 0;
//	}
//
//	/**
//	 * Returns the number of elements in the list.
//	 *
//	 * @return number of elements in the list
//	 */
//	@Override
//	public int size() {
//		return count;
//	}
//
//	/**
//	 * Returns a string representation of the list.
//	 *
//	 * @return String representation of the list
//	 */
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		for (T element : this)
//			sb.append(element + "\n");
//		return sb.toString();
//	}
//
//	/**
//	 * Returns a string representation of the list in reverse.
//	 *
//	 * @return String representation of the list in reverse
//	 */
//	public String reversedList() {
//		StringBuilder sb = new StringBuilder();
//		ReversedDoublyLinkedCircularListIterator<T> ri;
//		for (ri = reversedIterator(); ri.hasNext(); ri.next()) {
//			sb.append(ri.getElement() + "\n");
//		}
//		return sb.toString();
//	}
//
//	/**
//	 * Returns an iterator for the list that can be used to traverse the list
//	 * linearly.
//	 *
//	 * @return iterator for the list
//	 */
//	@Override
//	public Iterator<T> iterator() {
//		return new DoublyLinkedCircularListIterator<T>(front);
//	}
//
//	/**
//	 * Returns an iterator for the list that can be used to traverse the list in
//	 * reverse order.
//	 *
//	 * @return reverse iterator for the list
//	 */
//	public ReversedDoublyLinkedCircularListIterator<T> reversedIterator() {
//		return new ReversedDoublyLinkedCircularListIterator<T>(front);
//	}
//
//	private class DoublyLinkedCircularListIterator<T> implements Iterator<T> {
//		private DoubleNode<T> node;
//		private int i;
//
//		public DoublyLinkedCircularListIterator(DoubleNode<T> node) {
//			this.node = node;
//			this.i = 0;
//		}
//
//		@Override
//		public boolean hasNext() {
//			return i < count;
//		}
//
//		@Override
//		public T next() {
//			if (!hasNext())
//				throw new NoSuchElementException();
//			T element = node.getElement();
//			node = node.getNext();
//			i++;
//			return element;
//		}
//	}
//
//	private class ReversedDoublyLinkedCircularListIterator<T> implements Iterator<T> {
//		private DoubleNode<T> node;
//		private int i;
//
//		public ReversedDoublyLinkedCircularListIterator(DoubleNode<T> node) {
//			this.node = node.getPrevious();
//			this.i = 0;
//		}
//
//		@Override
//		public boolean hasNext() {
//			return i < count;
//		}
//
//		public T getElement() {
//			return node.getElement();
//		}
//
//		@Override
//		public T next() {
//			if (!hasNext())
//				throw new NoSuchElementException();
//			T element = node.getElement();
//			node = node.getPrevious();
//			i++;
//			return element;
//		}
//	}
//}
