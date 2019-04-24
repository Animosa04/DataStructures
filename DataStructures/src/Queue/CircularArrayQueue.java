package Queue;

public class CircularArrayQueue<T> implements QueueADT<T> {
	private final int DEFAULT_CAPACITY = 100;
	private T[] queue;
	private int front, rear, count;

	public CircularArrayQueue(int size) {
		queue = (T[]) new Object[size];
		front = 0;
		rear = 0;
		count = 0;
	}

	public CircularArrayQueue() {
		queue = (T[]) new Object[DEFAULT_CAPACITY];
		front = 0;
		rear = 0;
		count = 0;
	}

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

	@Override
	public T first() {
		if (count == 0)
			throw new IllegalStateException("Queue empty");
		return queue[front];
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	public void expand() {
		T[] bigger_queue = (T[]) new Object[queue.length * 2];
		for (int i = 0; i < queue.length; i++)
			bigger_queue[i] = queue[i];
		queue = bigger_queue;
		rear = count;
	}

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
