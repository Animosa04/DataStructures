package Stack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayStackTest {
	private ArrayStack<Integer> stack;

	@Before
	public void setUp() throws Exception {
		stack = new ArrayStack<>(3);
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
	}

	@Test
	public void testPush() {
		stack.push(4);
		Assert.assertFalse(stack.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPushNullElement() {
		stack.push(null);
	}

	@Test
	public void testStackExpand() {
		stack.push(2);
		stack.push(3);
		stack.push(6);
		Assert.assertEquals(3, stack.size());
		stack.push(9);
		Assert.assertEquals(4, stack.size());
	}

	@Test
	public void testPop() {
		stack.push(2);
		Assert.assertSame(2, stack.pop());
	}

	@Test(expected = IllegalStateException.class)
	public void testPopEmpty() {
		stack.pop();
	}

	@Test
	public void testPeek() {
		stack.push(2);
		Assert.assertSame(2, stack.peek());
	}

	@Test(expected = IllegalStateException.class)
	public void testPeekEmpty() {
		stack.peek();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertTrue(stack.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(0, stack.size());
		stack.push(2);
		stack.push(3);
		stack.push(4);
		Assert.assertEquals(3, stack.size());
		stack.pop();
		Assert.assertEquals(2, stack.size());
	}

}
