package Linked_List;

public class LinearNode<T> implements Node<T> {
	private LinearNode<T> next;
	private T element;

	LinearNode(T element) {
		this.element = element;
		this.next = null;
	}

	LinearNode(T element, LinearNode<T> next) {
		this.element = element;
		this.next = next;
	}

	@Override
	public T getElement() {
		return element;
	}

	@Override
	public void setElement(T element) {
		this.element = element;
	}

	@Override
	public LinearNode<T> getNext() {
		return next;
	}

	@Override
	public void setNext(Node<T> next) {
		this.next = (LinearNode<T>) next;
	}

}
