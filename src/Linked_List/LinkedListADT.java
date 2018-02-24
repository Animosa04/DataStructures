package Linked_List;

public interface LinkedListADT<T> {
	void add(T element);

	void add(int index, T element);

	void set(int index, T element);

	T get(int index);

	Node<T> getNode(int index);

	T remove(int index);

	T removeElement(T element);

	int indexOf(T element);

	boolean contains(T element);

	boolean isEmpty();

	int size();

	String toString();
}
