package Linked_List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class DoublyLinkedCircularListTest {
	private DoublyLinkedCircularList<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new DoublyLinkedCircularList<>();
	}

	@After
	public void tearDown() throws Exception {
		list = null;
	}

	@Test
	public void testAddShouldWork() {
		list.add(3);
		Assert.assertEquals(1, list.size());
		list.add(4);
		list.add(8);
		list.add(5);
		Assert.assertEquals(4, list.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNull() {
		list.add(null);
	}

	@Test
	public void testAddAtIndex() {
		list.add(0, 5);
		list.add(0, 4);
		list.add(1, 3);
		Assert.assertSame(3, list.get(1));
		list.add(1, 4);
		Assert.assertSame(4, list.get(1));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddInvalidIndex() {
		list.add(4, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddInvalidArgument() {
		list.add(0, null);
	}

	@Test
	public void testSetShouldWork() {
		list.add(5);
		list.set(0, 2);
		Assert.assertSame(2, list.get(0));
		list.add(7);
		list.add(9);
		list.set(2, 8);
		Assert.assertSame(8, list.get(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetInvalidArgument() {
		list.add(5);
		list.set(0, null);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetInvalidIndex() {
		list.add(5);
		list.set(1, 8);
	}

	@Ignore
	@Test
	public void testGetByIndexShouldWork() {
		list.add(7);
		Assert.assertSame(7, list.get(0));
		list.add(10);
		Assert.assertSame(10, list.get(1));
		list.add(3);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetByIndexInvalidIndex() {
		list.add(7);
		list.get(4);
	}

	@Test(expected = IllegalStateException.class)
	public void testGetByIndexEmptyList() {
		list.get(0);
	}

	@Test
	public void testRemoveByIndexShouldWork() {
		list.add(5);
		Assert.assertFalse(list.isEmpty());
		list.remove(0);
		Assert.assertTrue(list.isEmpty());
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveByIndexEmptyList() {
		list.remove(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveByIndexInvalidIndex() {
		list.add(5);
		list.remove(6);
	}

	@Test
	public void testRemoveByElementShouldWork() {
		list.add(4);
		list.removeElement(4);
		list.add(9);
		list.add(6);
		list.add(10);
		list.removeElement(6);
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveByElementNotFound() {
		list.add(4);
		list.removeElement(3);
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveByElementEmptyList() {
		list.removeElement(3);
	}

	@Test
	public void testIndexOf() {
		list.add(50);
		list.add(36);
		list.add(73);
		list.add(46);
		list.add(95);
		list.add(30);
		Assert.assertSame(3, list.indexOf(46));
		Assert.assertSame(0, list.indexOf(50));
		Assert.assertNotSame(4, list.indexOf(12));
		Assert.assertSame(5, list.indexOf(30));
		Assert.assertEquals(-1, list.indexOf(20));
		Assert.assertSame(-1, list.indexOf(79));
	}

	@Test
	public void testContains() {
		Assert.assertFalse(list.contains(45));
		list.add(95);
		Assert.assertTrue(list.contains(95));
		list.add(30);
		Assert.assertTrue(list.contains(30));
		Assert.assertFalse(list.contains(89));
	}

	@Test
	public void testIsEmpty() {
		Assert.assertTrue(list.isEmpty());
		list.add(30);
		Assert.assertFalse(list.isEmpty());
		list.remove(0);
		Assert.assertTrue(list.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertSame(0, list.size());
		list.add(30);
		Assert.assertSame(1, list.size());
		list.add(50);
		list.add(36);
		Assert.assertSame(3, list.size());
		list.add(73);
		list.add(46);
		list.add(95);
		list.add(30);

		Assert.assertNotSame(12, list.size());
	}
}
