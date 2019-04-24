package DoublyLinkedList;

public interface DoublyLinkedListADT<T> {

	void addAsFirstElement(T element);

	void addAfter(int index, T element);

	void addAsLastElement(T element);

	void set(int index, T element);

	T get(int index);

	T remove(int index);

	T removeElement(T element);

	T removeLastElement();

	void clear();

	int indexOf(T element);

	boolean contains(T element);

	boolean isEmpty();

	int size();

    DoubleNode<T> getNode(int index);

    String forwardListTraversalString();

	String reverseListTraversalString();
}
