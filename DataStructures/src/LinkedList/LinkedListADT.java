package LinkedList;

public interface LinkedListADT<T> {

	void add(T element);

	void set(int index, T element);

	T get(int index);

	T remove(int index);

	T removeElement(T element);

	void clear();

	int indexOf(T element);

	boolean contains(T element);

	boolean isEmpty();

	int size();

	LinearNode<T> getNode(int index);

	String toString();
}
