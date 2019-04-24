package DoublyLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    private DoublyLinkedList<String> doublyLinkedList;

    @Before
    public void beforeEach(){
        doublyLinkedList = new DoublyLinkedList<String>();
    }

    @Test
    public void testAddAsFirstElement() {
        doublyLinkedList.addAsFirstElement("abc");
        assertEquals(doublyLinkedList.size(), 1);
        assertEquals(doublyLinkedList.toString(), "[abc]");
        doublyLinkedList.addAsFirstElement("def");
        assertEquals(doublyLinkedList.size(), 2);
        assertEquals(doublyLinkedList.toString(), "[def, abc]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAsFirstElementNullElement() {
        doublyLinkedList.addAsFirstElement(null);
    }

    @Test
    public void testAddAfter() {
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.addAfter(0, "b");
        assertEquals(doublyLinkedList.size(), 2);
        assertEquals(doublyLinkedList.toString(), "[a, b]");
        doublyLinkedList.addAfter(0, "c");
        assertEquals(doublyLinkedList.size(), 3);
        assertEquals(doublyLinkedList.toString(), "[a, c, b]");
        doublyLinkedList.addAfter(1, "d");
        assertEquals(doublyLinkedList.size(), 4);
        assertEquals(doublyLinkedList.toString(), "[a, c, d, b]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAfterNullElement() {
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.addAfter(0, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAfterInvalidIndex() {
        doublyLinkedList.addAfter(0, "a");
    }

    @Test
    public void testAddAsLastElement() {
        doublyLinkedList.addAsLastElement("a");
        assertEquals(doublyLinkedList.size(), 1);
        assertEquals(doublyLinkedList.toString(), "[a]");
        doublyLinkedList.addAsLastElement("b");
        doublyLinkedList.addAsLastElement("c");
        assertEquals(doublyLinkedList.size(), 3);
        assertEquals(doublyLinkedList.toString(), "[a, b, c]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAsLastElementNullElement() {
        doublyLinkedList.addAsLastElement(null);
    }

    @Test
    public void testSetElement() {
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.addAsLastElement("b");
        doublyLinkedList.addAsLastElement("c");
        doublyLinkedList.set(0, "d");
        assertEquals(doublyLinkedList.toString(), "[d, b, c]");
        doublyLinkedList.set(1, "e");
        assertEquals(doublyLinkedList.toString(), "[d, e, c]");
        doublyLinkedList.set(2, "f");
        assertEquals(doublyLinkedList.toString(), "[d, e, f]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullElement() {
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.set(0, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetElementInvalidIndex() {
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.set(2, "b");
    }

    @Test
    public void testGetElement() {
        doublyLinkedList.addAsLastElement("a");
        assertEquals(doublyLinkedList.get(0), "a");
        doublyLinkedList.addAsLastElement("b");
        assertEquals(doublyLinkedList.get(1), "b");
        doublyLinkedList.addAsLastElement("c");
        assertEquals(doublyLinkedList.get(2), "c");
        doublyLinkedList.addAfter(0, "d");
        assertEquals(doublyLinkedList.get(1), "d");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetElementInvalidIndex() {
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.get(3);
    }

    @Test
    public void testRemove() {
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.addAsLastElement("b");
        assertEquals(doublyLinkedList.remove(1), "b");
        assertEquals(doublyLinkedList.size(), 1);
        assertEquals(doublyLinkedList.remove(0), "a");
        assertEquals(doublyLinkedList.size(), 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidIndex() {
        doublyLinkedList.remove(0);
    }

    @Test
    public void testRemoveElement() {
        doublyLinkedList.addAsFirstElement("a");
        assertEquals(doublyLinkedList.removeElement("a"), "a");
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveElementNotFound(){
        doublyLinkedList.removeElement("abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullElement() {
        doublyLinkedList.removeElement(null);
    }

    @Test
    public void removeLastElement() {
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.addAsLastElement("b");
        assertEquals(doublyLinkedList.removeLastElement(), "b");
        assertEquals(doublyLinkedList.removeLastElement(), "a");
    }

    @Test(expected = IllegalStateException.class)
    public void removeLastElementListEmpty() {
        doublyLinkedList.removeLastElement();
    }

    @Test
    public void clear() {
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.clear();
        assertTrue(doublyLinkedList.isEmpty());
    }

    @Test
    public void indexOf() {
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.addAsLastElement("b");
        doublyLinkedList.addAsLastElement("c");
        assertEquals(doublyLinkedList.indexOf("a"), 0);
        assertEquals(doublyLinkedList.indexOf("b"), 1);
        assertEquals(doublyLinkedList.indexOf("c"), 2);
        assertEquals(doublyLinkedList.indexOf("d"), -1);
        assertEquals(doublyLinkedList.indexOf("e"), -1);
    }

    @Test
    public void contains() {
        doublyLinkedList.addAsLastElement("a");
        doublyLinkedList.addAsLastElement("b");
        assertTrue(doublyLinkedList.contains("a"));
        assertTrue(doublyLinkedList.contains("b"));
        assertFalse(doublyLinkedList.contains("c"));
        assertFalse(doublyLinkedList.contains("d"));
    }

    @Test
    public void isEmpty() {
        assertTrue(doublyLinkedList.isEmpty());
        doublyLinkedList.addAsLastElement("a");
        assertFalse(doublyLinkedList.isEmpty());
        doublyLinkedList.clear();
        assertTrue(doublyLinkedList.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(doublyLinkedList.size(), 0);
        doublyLinkedList.addAsLastElement("a");
        assertEquals(doublyLinkedList.size(), 1);
        doublyLinkedList.addAsLastElement("b");
        assertEquals(doublyLinkedList.size(), 2);
        doublyLinkedList.clear();
        assertEquals(doublyLinkedList.size(), 0);
    }

    @Test
    public void forwardListTraversalString() {
        assertEquals(doublyLinkedList.forwardListTraversalString(), "[]");
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.addAsFirstElement("b");
        doublyLinkedList.addAsFirstElement("c");
        assertEquals(doublyLinkedList.forwardListTraversalString(), "[c, b, a]");
    }

    @Test
    public void reverseListTraversalString() {
        assertEquals(doublyLinkedList.reverseListTraversalString(), "[]");
        doublyLinkedList.addAsFirstElement("a");
        doublyLinkedList.addAsFirstElement("b");
        doublyLinkedList.addAsFirstElement("c");
        assertEquals(doublyLinkedList.reverseListTraversalString(), "[a, b, c]");
    }
}