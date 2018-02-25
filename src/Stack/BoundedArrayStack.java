package Stack;

public class BoundedArrayStack<T> implements StackADT<T> {
	/**
	 * constant to represent the default capacity of the stack
	 */
	private final int DEFAULT_SIZE = 10;
	/**
	 * array of generic elements to represent the stack
	 */
	private T[] stack;
	/**
	 * int representing both the size of the stack and the next available index for
	 * inserting an element in the stack
	 */
	private int top;

	/**
	 * Creates an empty stack with specified capacity.
	 * 
	 * @param size
	 *            specifying the capacity of the stack
	 */
	public BoundedArrayStack(int size) {
		stack = (T[]) new Object[size];
		top = 0;
	}

	/**
	 * Created an empty stack with default capacity.
	 */
	public BoundedArrayStack() {
		stack = (T[]) new Object[DEFAULT_SIZE];
		top = 0;
	}

	/**
	 * Adds the specified generic element to the top of the stack. Null elements are
	 * not permitted in the stack. If a push is attempted on a full stack,
	 * IllegalStateException is thrown.
	 * 
	 * @throws IllegalStateException
	 *             if the stack is full
	 * @throws IllegalArgumentException
	 *             if the element is null
	 */
	@Override
	public void push(T element) {
		if (size() == stack.length)
			throw new IllegalStateException("Stack full");
		if (element == null)
			throw new IllegalArgumentException("Element cannot be null");
		stack[top] = element;
		top++;
	}

	/**
	 * Removes and returns the element on top of the stack. Throws an
	 * IllegalStateException if the stack is empty.
	 * 
	 * @return T element removed from top of the stack
	 * @throws IllegalStateException
	 *             if pop is attempted on empty stack
	 */
	@Override
	public T pop() {
		if (isEmpty())
			throw new IllegalStateException("Stack empty");
		T top_element = stack[top - 1];
		stack[top - 1] = null;
		top--;
		return top_element;
	}

	/**
	 * Returns without removing the element on top of the stack. Throws an
	 * IllegalStateException if the stack is empty.
	 * 
	 * @return T element on top of the stack
	 * @throws IllegalStateException
	 *             if peek is attempted on empty stack
	 */
	@Override
	public T peek() {
		if (isEmpty())
			throw new IllegalStateException("Stack empty");
		return stack[top - 1];
	}

	/**
	 * Returns whether the stack is empty or not. If the top index is 0, it means
	 * there are no elements in the stack.
	 *
	 * @return true if the top index is 0
	 */
	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	/**
	 * Returns the number of elements in the stack. The top index represents the
	 * number of elements in the stack.
	 * 
	 * @return int representing the number of elements in the stack
	 */
	@Override
	public int size() {
		return top;
	}

	/**
	 * Returns a string representation of the stack.
	 * 
	 * @return String representation of the stack
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < stack.length; i++) {
			sb.append(stack[i] + ", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		return sb.toString();
	}
}
