package Linked_List;

public class DoubleNode<T> implements Node<T> {
	private DoubleNode<T> previous;
	private DoubleNode<T> next;
	private T element;

	public DoubleNode(T element) {
		this.element = element;
		previous = null;
		next = null;
	}

	public DoubleNode(T element, DoubleNode<T> previous, DoubleNode<T> next) {
		this.element = element;
		this.previous = previous;
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
	public DoubleNode<T> getNext() {
		return next;
	}

	@Override
	public void setNext(Node<T> next) {
		this.next = (DoubleNode<T>) next;
	}

	public DoubleNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleNode<T> previous) {
		this.previous = previous;
	}
}
