package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements LinkedListADT<T>, Iterable<T> {

	private LinearNode<T> head;
	private LinearNode<T> rear;
	private int count;

	SinglyLinkedList() {
		head = null;
		count = 0;
	}

	@Override
	public void add(T element) {
		checkElementNotNull(element);
		LinearNode<T> newNode = new LinearNode<>(element);
		if (head == null) {
			head = newNode;
			rear = newNode;
		} else {
			rear.setNext(newNode);
			rear = newNode;
		}
		count++;
	}

	@Override
	public void set(int index, T element) {
		checkElementNotNull(element);
		getNode(index).setElement(element);
	}

	@Override
	public T get(int index) {
		return getNode(index).getElement();
	}

	@Override
	public T remove(int index) {
		checkIndexInBounds(index);
		LinearNode<T> toRemove;
		if (index == 0) {
			toRemove = head;
			head = head.getNext();
		} else {
			LinearNode<T> previousNode = getNode(index-1);
			toRemove = previousNode.getNext();
			previousNode.setNext(toRemove.getNext());
		}
		count--;
		return toRemove.getElement();
	}

	@Override
	public T removeElement(T element) {
		checkElementNotNull(element);
		int index = indexOf(element);
		if(index == -1)
			throw new IllegalStateException("Element not found");
		else
			return remove(index);
	}

	@Override
	public void clear() {
		head = null;
		count = 0;
	}

	@Override
	public int indexOf(T element) {
        if (isEmpty()) {
            return -1;
        }
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
    public LinearNode<T> getNode(int index) {
        checkIndexInBounds(index);
        LinearNode<T> result = head;
        for (int i = 0; i < index; i++) {
            result = result.getNext();
        }
        return result;
    }

	@Override
    public String toString() {
        if(isEmpty())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T node : this)
            sb.append(node).append(", ");
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    @Override
	public Iterator<T> iterator() {
		return new SinglyLinkedListIterator<>(head);
	}

    private class SinglyLinkedListIterator<T> implements Iterator<T> {

		private LinearNode<T> node;

		SinglyLinkedListIterator(LinearNode<T> node) {
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

	private void checkIndexInBounds(int index){
	    if (index < 0 || index > count - 1)
			throw new IndexOutOfBoundsException("Index out of bounds");
	}

	private void checkElementNotNull(T element) {
		if (element == null)
			throw new IllegalArgumentException("Element cannot be null");
	}

}
