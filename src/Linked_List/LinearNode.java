package Linked_List;

public class LinearNode<T> implements Node<T> {
	/**
	 * reference to next node
	 */
	private LinearNode<T> next;
	/**
	 * generic element inside node
	 */
	private T element;

	/**
	 * Creates a node of a generic type with a generic element inside.
	 * 
	 * @param element
	 *            inside node
	 */
	LinearNode(T element) {
		this.element = element;
		this.next = null;
	}

	/**
	 * Creates a node of a generic type with a generic element inside and a
	 * reference to next node.
	 * 
	 * @param element
	 *            inside node
	 * @param reference
	 *            to next node
	 */
	LinearNode(T element, LinearNode<T> next) {
		this.element = element;
		this.next = next;
	}

	/**
	 * Returns the element inside the node.
	 * 
	 * @return T element inside the node
	 */
	@Override
	public T getElement() {
		return element;
	}

	/**
	 * Sets the element inside the node.
	 * 
	 * @param element
	 *            to put in the node
	 */
	@Override
	public void setElement(T element) {
		this.element = element;
	}

	/**
	 * Returns a reference to the next node.
	 * 
	 * @return a reference to next node
	 */
	@Override
	public LinearNode<T> getNext() {
		return next;
	}

	/**
	 * Sets the next node of a node.
	 * 
	 * @param reference
	 *            to next node
	 */
	@Override
	public void setNext(Node<T> next) {
		this.next = (LinearNode<T>) next;
	}

}
