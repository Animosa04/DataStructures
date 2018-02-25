package Stack;

public interface StackADT<T> {
	/**
	 * Adds an element to the top of the stack.
	 * 
	 * @param element
	 *            element to be pushed to the top of the stack
	 */
	void push(T element);

	/**
	 * Removes and return the top element of the stack.
	 * 
	 * @return T element removed from the top of the stack
	 */
	T pop();

	/**
	 * Returns without removing the top element of the stack.
	 * 
	 * @return T element on top of the stack
	 */
	T peek();

	/**
	 * Returns true if the stack is empty.
	 * 
	 * @return boolean whether the stack is empty
	 */
	boolean isEmpty();

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return int representing the number of elements in the stack
	 */
	int size();

	/**
	 * Returns a string representation of the stack.
	 * 
	 * @return String representation of the stack
	 */
	String toString();
}
