package Linked_List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements LinkedListADT<T>, Iterable<T> {
	/**
	 * reference to the front element of the list
	 */
	private LinearNode<T> front;
	/**
	 * int representing the number of elements in the list
	 */
	int count;

	/**
	 * Creates an empty singly linked list of a generic type.
	 */
	public SinglyLinkedList() {
		front = null;
		count = 0;
	}

	/**
	 * Adds an element at the end of the list. Null elements are not permitted.
	 * 
	 * @param element
	 *            element to be added to the list
	 * @throws IllegalArgumentException
	 *             if element is null
	 */
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

	/**
	 * Adds an element at the specified index. Null elements are not permitted.
	 * 
	 * @param index
	 *            index where the element should be placed
	 * @param element
	 *            element to be added to the list
	 * @throws IndexOutOfBoundsException
	 *             if the specified index is out of bounds
	 * @throws IllegalArgumentException
	 *             if element is null
	 */
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

	/**
	 * Sets the element of the node at the specified index. Null elements are not
	 * permitted.
	 * 
	 * @param index
	 *            index of the node whose element is to be set
	 * @param element
	 *            element to be set as the node's new element
	 * @throws IllegalArgumentException
	 *             if element is null
	 */
	@Override
	public void set(int index, T element) {
		if (element == null)
			throw new IllegalArgumentException("Element cannot be null");

		getNode(index).setElement(element);
	}

	/**
	 * Returns the element of the node at the specified index.
	 * 
	 * @param index
	 *            index of node
	 * @return element of the node at the specified index
	 */
	@Override
	public T get(int index) {
		return getNode(index).getElement();
	}

	/**
	 * Returns the node at the specified index.
	 * 
	 * @param index
	 *            index of node
	 * @return node at the specified index
	 * @throws IllegalStateException
	 *             if the list is empty
	 * @throws IndexOutOfBoundsException
	 *             if index is out out bounds
	 */
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

	/**
	 * Removes the node at the specified index and returns its element.
	 * 
	 * @param index
	 *            index of the node to be removed
	 * @return element of the removed node
	 * @throws IllegalStateException
	 *             if the list is empty
	 * @throws IndexOutOfBoundsException
	 *             if index is out of bounds
	 */
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

	/**
	 * Removes a node with the specified element and returns the element.
	 * 
	 * @param element
	 *            to be removed from the list
	 * @return element removed
	 * @throws IllegalStateException
	 *             if the element is not in the list
	 */
	@Override
	public T removeElement(T element) {
		try {
			return remove(indexOf(element));
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalStateException("Element not found");
		}
	}

	/**
	 * Returns the index of a specified element in the list.
	 * 
	 * @param element
	 *            whose index is searched
	 * @return index of the specified element, -1 if the element is not in the list
	 */
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

	/**
	 * Returns whether the element specified is in the list. If the index of the
	 * element is not -1, it means that the element is in the list.
	 * 
	 * @param element
	 *            element to check if is present in the list
	 * @return true if the element is in the list
	 */
	@Override
	public boolean contains(T element) {
		return indexOf(element) != -1;
	}

	/**
	 * Returns whether the list is empty or not.
	 * 
	 * @return true if the size of the list is 0
	 */
	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * Returns an iterator for the list that can be used to traverse the list
	 * linearly.
	 * 
	 * @return iterator for the list
	 */
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

	/**
	 * Returns a string representation of the list.
	 * 
	 * @return String representation of the list
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (T node : this) {
			sb.append(node + ", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		return sb.toString();
	}
}
