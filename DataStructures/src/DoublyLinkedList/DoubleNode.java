package DoublyLinkedList;

public class DoubleNode<T> {

	private DoubleNode<T> next;
	private DoubleNode<T> previous;

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

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public DoubleNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}

	public DoubleNode<T> getPrevious() {
		return previous;
	}


	public void setPrevious(DoubleNode<T> previous) {
		this.previous = previous;
	}
}
