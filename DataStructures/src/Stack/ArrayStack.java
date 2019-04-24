package Stack;

public class ArrayStack<T> implements StackADT<T> {
	private final int DEFAULT_SIZE = 100;
	private T[] stack;
	private int top;

	public ArrayStack(int size) {
		stack = (T[]) new Object[size];
		top = 0;
	}

	public ArrayStack() {
		stack = (T[]) new Object[DEFAULT_SIZE];
		top = 0;
	}

	@Override
	public void push(T element) {
		if (size() == stack.length)
			expand();
		if (element == null)
			throw new IllegalArgumentException("Element cannot be null");
		stack[top] = element;
		top++;
	}

	@Override
	public T pop() {
		if (isEmpty())
			throw new IllegalStateException("Stack empty");
		T top_element = stack[top - 1];
		stack[top - 1] = null;
		top--;
		return top_element;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new IllegalStateException("Stack empty");
		return stack[top - 1];
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public int size() {
		return top;
	}

	public void expand() {
		T[] bigger_stack = (T[]) new Object[stack.length * 2];
		for (int i = 0; i < stack.length; i++) {
			bigger_stack[i] = stack[i];
		}
		stack = bigger_stack;
	}

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
