package LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList<String> singlyLinkedList;

    @Before
    public void beforeEach(){
        singlyLinkedList = new SinglyLinkedList<>();
    }

    @Test
    public void testAddElement(){
        singlyLinkedList.add("abc");
        assertEquals(singlyLinkedList.size(), 1);
        assertEquals(singlyLinkedList.toString(), "[abc]");
        singlyLinkedList.add("def");
        assertEquals(singlyLinkedList.size(), 2);
        assertEquals(singlyLinkedList.toString(), "[abc, def]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullElement() {
        singlyLinkedList.add(null);
    }

    @Test
    public void testSetElement(){
        singlyLinkedList.add("a");
        singlyLinkedList.add("b");
        singlyLinkedList.add("c");
        assertEquals(singlyLinkedList.toString(), "[a, b, c]");
        singlyLinkedList.set(0, "d");
        assertEquals(singlyLinkedList.toString(), "[d, b, c]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullElement(){
        singlyLinkedList.add("a");
        singlyLinkedList.set(0, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetElementInvalidIndex(){
        singlyLinkedList.add("a");
        singlyLinkedList.set(2, "b");
    }

    @Test
    public void testGetElement(){
        singlyLinkedList.add("abc");
        singlyLinkedList.add("def");
        assertEquals(singlyLinkedList.get(0), "abc");
        assertEquals(singlyLinkedList.get(1), "def");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetElementInvalidIndex(){
        singlyLinkedList.add("a");
        singlyLinkedList.get(4);
    }

    @Test
    public void testRemove(){
        singlyLinkedList.add("a");
        singlyLinkedList.remove(0);
        assertEquals(singlyLinkedList.size(), 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidIndex(){
        singlyLinkedList.add("abc");
        singlyLinkedList.remove(5);
    }

    @Test
    public void testRemoveElement(){
        singlyLinkedList.add("abc");
        assertEquals(singlyLinkedList.removeElement("abc"), "abc");
        assertEquals(singlyLinkedList.size(), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveElementNotFound(){
        singlyLinkedList.removeElement("abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullElement() {
        singlyLinkedList.removeElement(null);
    }

    @Test
    public void testClear(){
        singlyLinkedList.add("a");
        singlyLinkedList.add("b");
        singlyLinkedList.clear();
        assertEquals(singlyLinkedList.size(), 0);
        assertEquals(singlyLinkedList.toString(), "[]");
    }

    @Test
    public void testIndexOfExistingElement(){
        singlyLinkedList.add("a");
        singlyLinkedList.add("b");
        singlyLinkedList.add("c");
        assertEquals(singlyLinkedList.indexOf("a"), 0);
        assertEquals(singlyLinkedList.indexOf("b"), 1);
        assertEquals(singlyLinkedList.indexOf("c"), 2);
    }

    @Test
    public void testIndexOfNonExistingElement(){
        assertEquals(singlyLinkedList.indexOf("a"), -1);
    }

    @Test
    public void testContainsElement(){
        singlyLinkedList.add("a");
        singlyLinkedList.add("b");
        assertTrue(singlyLinkedList.contains("a"));
        assertTrue(singlyLinkedList.contains("b"));
        assertFalse(singlyLinkedList.contains("c"));
        assertFalse(singlyLinkedList.contains("d"));
    }

    @Test
    public void testIsEmpty(){
        assertTrue(singlyLinkedList.isEmpty());
        singlyLinkedList.add("abc");
        assertFalse(singlyLinkedList.isEmpty());
        singlyLinkedList.removeElement("abc");
        assertTrue(singlyLinkedList.isEmpty());
    }

    @Test
    public void testSize(){
        assertEquals(singlyLinkedList.size(), 0);
        singlyLinkedList.add("a");
        singlyLinkedList.add("b");
        assertEquals(singlyLinkedList.size(), 2);
    }

    @Test
    public void testToString(){
        assertEquals(singlyLinkedList.toString(), "[]");
        singlyLinkedList.add("a");
        singlyLinkedList.add("b");
        assertEquals(singlyLinkedList.toString(), "[a, b]");
    }
}