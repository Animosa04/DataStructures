package Queue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircularArrayQueueTest {
	private CircularArrayQueue<Integer> queue;

	@Before
	public void setUp() throws Exception {
		queue = new CircularArrayQueue<>(3);
	}

	@After
	public void tearDown() throws Exception {
		queue = null;
	}

	@Test
	public void testEnqueue() {
		queue.enqueue(4);
		Assert.assertFalse(queue.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEnqueueNullElement() {
		queue.enqueue(null);
	}

	@Test
	public void testQueueExpand() {
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(6);
		Assert.assertEquals(3, queue.size());
		queue.enqueue(9);
		Assert.assertEquals(4, queue.size());
	}

	@Test
	public void testDequeue() {
		queue.enqueue(2);
		Assert.assertSame(2, queue.dequeue());
	}

	@Test(expected = IllegalStateException.class)
	public void testDequeueEmpty() {
		queue.dequeue();
	}

	@Test
	public void testFirst() {
		queue.enqueue(2);
		Assert.assertSame(2, queue.first());
		queue.enqueue(3);
		Assert.assertSame(2, queue.first());
		queue.dequeue();
		Assert.assertSame(3, queue.first());
	}

	@Test(expected = IllegalStateException.class)
	public void testFirstEmpty() {
		queue.first();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertTrue(queue.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(0, queue.size());
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		Assert.assertEquals(3, queue.size());
		queue.dequeue();
		Assert.assertEquals(2, queue.size());
	}
}
