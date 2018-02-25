package Linked_List;

public interface Node<T> {
	/**
	 * Returns the element inside the node.
	 * 
	 * @return T element inside the node
	 */
	public T getElement();

	/**
	 * Sets the element inside the node.
	 * 
	 * @param element
	 *            to put in the node
	 */
	public void setElement(T element);

	/**
	 * Returns a reference to the next node.
	 * 
	 * @return a reference to next node
	 */
	Node<T> getNext();

	/**
	 * Sets the next node of a node.
	 * 
	 * @param reference
	 *            to next node
	 */
	void setNext(Node<T> next);

}
