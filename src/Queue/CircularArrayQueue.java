package Queue;

public class CircularArrayQueue<T> implements QueueADT<T> {
	private static int DEFAULT_CAPACITY = 100;
	private int front = 0, count = 0, rear = 0;
	private T[] queue;

	public CircularArrayQueue(int size) {
		queue = (T[]) new Object[size];
	}

	public CircularArrayQueue() {
		queue = (T[]) new Object[DEFAULT_CAPACITY];
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
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < queue.length; i++) {
			sb.append(queue[i] + "\n");
		}
		return sb.toString();
	}
}
