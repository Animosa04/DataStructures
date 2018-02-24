package Stack;

public interface StackADT<T> {
	// Adds an element to the top of the stack
	void push(T element);

	// Removes and returns the element on the top of the stack
	T pop();

	// Returns without removing the element at the top of the stack
	T peek();

	// Returns if the stack is empty
	boolean isEmpty();

	// Returns the size of the stack
	int size();

	// Returns a string representation of the stack
	String toString();
}
