package Queue;

public interface QueueADT<T> {
	/**
	 * Adds an element to the rear of the queue.
	 * 
	 * @param element
	 *            to be added to the rear of the queue
	 */
	void enqueue(T element);

	/**
	 * Removes and returns the front element of the queue.
	 * 
	 * @return T element removed from the front of the queue
	 */
	T dequeue();

	/**
	 * Returns the front element of the queue without removing it.
	 * 
	 * @return T element on the front of the queue
	 */
	T first();

	/**
	 * Returns true if the queue is empty.
	 * 
	 * @return boolean representing whether the queue is empty
	 */
	boolean isEmpty();

	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return int representing the number of elements of the queue
	 */
	int size();

	/**
	 * Returns a string representation of the queue
	 * 
	 * @returnString representation of the queue
	 */
	String toString();
}
