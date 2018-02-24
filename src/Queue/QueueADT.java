package Queue;

public interface QueueADT<T> {
	// Adds an element to the rear of the queue
	void enqueue(T element);

	// Removes and returns the front element in the queue
	T dequeue();

	// Returns without removing the front element of the queue
	T first();

	// Returns if a queue is empty
	boolean isEmpty();

	// Returns the size of a queue
	int size();

	// Returns a string representation of a queue
	String toString();
}
