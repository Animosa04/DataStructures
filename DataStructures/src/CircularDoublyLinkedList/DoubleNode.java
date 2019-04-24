//package Linked_List.CircularDoublyLinkedList;
//
//public class DoubleNode<T> implements Node<T> {
//	/**
//	 * reference to next node
//	 */
//	private DoubleNode<T> next;
//	/**
//	 * reference to previous node
//	 */
//	private DoubleNode<T> previous;
//	/**
//	 * generic element inside node
//	 */
//	private T element;
//
//	/**
//	 * Creates a node of a generic type with a generic element inside.
//	 *
//	 * @param element
//	 *            inside node
//	 */
//	public DoubleNode(T element) {
//		this.element = element;
//		previous = null;
//		next = null;
//	}
//
//	/**
//	 * Creates a node of a generic type with a generic element inside and a
//	 * reference to previous and next nodes.
//	 *
//	 * @param element
//	 *            inside node
//	 * @param reference
//	 *            to previous node
//	 * @param reference
//	 *            to next node
//	 */
//	public DoubleNode(T element, DoubleNode<T> previous, DoubleNode<T> next) {
//		this.element = element;
//		this.previous = previous;
//		this.next = next;
//	}
//
//	/**
//	 * Returns the element inside the node.
//	 *
//	 * @return T element inside the node
//	 */
//	@Override
//	public T getElement() {
//		return element;
//	}
//
//	/**
//	 * Sets the element inside the node.
//	 *
//	 * @param element
//	 *            to put in the node
//	 */
//	@Override
//	public void setElement(T element) {
//		this.element = element;
//	}
//
//	/**
//	 * Returns a reference to the next node.
//	 *
//	 * @return a reference to next node
//	 */
//	@Override
//	public DoubleNode<T> getNext() {
//		return next;
//	}
//
//	/**
//	 * Sets the next node of a node.
//	 *
//	 * @param reference
//	 *            to next node
//	 */
//	@Override
//	public void setNext(Node<T> next) {
//		this.next = (DoubleNode<T>) next;
//	}
//
//	/**
//	 * Returns a reference to the previous node.
//	 *
//	 * @return a reference to previous node
//	 */
//	public DoubleNode<T> getPrevious() {
//		return previous;
//	}
//
//	/**
//	 * Sets the previous node of a node.
//	 *
//	 * @param reference
//	 *            to previous node
//	 */
//	public void setPrevious(DoubleNode<T> previous) {
//		this.previous = previous;
//	}
//}
