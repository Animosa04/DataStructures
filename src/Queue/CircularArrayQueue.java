package Queue;

public class CircularArrayQueue<T> implements QueueADT<T> {
	/**
	 * constant representing the default capacity of a queue
	 */
	private final int DEFAULT_CAPACITY = 100;
	/**
	 * an array of generic elements representing the queue
	 */
	private T[] queue;
	/**
	 * ints representing the index of the front element of the queue, the index of
	 * the rear element of the queue, and the number of elements in the queue
	 * respectively
	 */
	private int front, rear, count;

	/**
	 * Creates an empty queue with a specified capacity.
	 * 
	 * @param size
	 *            representing the specified capacity of the queue
	 */
	public CircularArrayQueue(int size) {
		queue = (T[]) new Object[size];
		front = 0;
		rear = 0;
		count = 0;
	}

	/**
	 * Creates an empty queue with a default capacity.
	 */
	public CircularArrayQueue() {
		queue = (T[]) new Object[DEFAULT_CAPACITY];
		front = 0;
		rear = 0;
		count = 0;
	}

	/**
	 * Adds an element at the rear of the queue. Null elements are not allowed in
	 * the queue. Expands the array representing the queue if an enqueue is
	 * attempted on a full queue.
	 * 
	 * @param element
	 *            to be enqueued
	 * @throws IllegalArgumentException
	 *             if element is null
	 */
	@Override
	public void enqueue(T element) {
		if (element == null)
			throw new IllegalArgumentException("Element cannot be null");
		if (size() == queue.length)
			expand();
		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		count++;
	}

	/**
	 * Removes and returns the rear element of the queue. Throws an
	 * IllegalStateException if the queue is empty.
	 * 
	 * @return T element removed from the rear of the queue
	 * @throws IllegalStateException
	 *             if dequeue is attempted on empty queue
	 */
	@Override
	public T dequeue() {
		if (count == 0)
			throw new IllegalStateException("Queue empty");
		T first = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		count--;
		return first;
	}

	/**
	 * Removes and returns the first element in the queue. Throws an
	 * IllegalStateException if the queue is empty.
	 * 
	 * @return T element representing the first element in the queue
	 * @throws IllegalStateException
	 *             if first is attempted on empty queue
	 */
	@Override
	public T first() {
		if (count == 0)
			throw new IllegalStateException("Queue empty");
		return queue[front];
	}

	/**
	 * Returns whether the queue is empty or not. If the count is 0, it means there
	 * are no elements in the stack.
	 *
	 * @return true if the count is 0
	 */
	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return int representing the number of elements in the queue
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * Doubles the size of the array representing the queue
	 */
	public void expand() {
		T[] bigger_queue = (T[]) new Object[queue.length * 2];
		for (int i = 0; i < queue.length; i++)
			bigger_queue[i] = queue[i];
		queue = bigger_queue;
		rear = count;
	}

	/**
	 * Returns a string representation of the queue.
	 * 
	 * @return String representation of the queue
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < queue.length; i++) {
			sb.append(queue[i] + ", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("]");
		return sb.toString();
	}
}
