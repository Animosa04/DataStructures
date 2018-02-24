package Linked_List;

public interface Node<T> {
	public T getElement();

	public void setElement(T element);

	Node<T> getNext();

	void setNext(Node<T> next);

}
