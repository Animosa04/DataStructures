package CircularLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularSinglyLinkedList<T> implements CircularSinglyLinkedListADT<T>, Iterable<T> {

    private LinearNode<T> head;
    private LinearNode<T> rear;
    private int count;

    @Override
    public void add(T element) {
        checkElementNotNull(element);
        LinearNode<T> newNode = new LinearNode<>(element);
        if(head == null){
            head = newNode;
            rear = newNode;
            rear.setNext(head);
        } else {
            rear.setNext(newNode);
            rear = newNode;
            rear.setNext(head);
        }
    }

    @Override
    public void set(int index, T element) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T removeElement(T element) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public LinearNode<T> getNode(int index) {
        return null;
    }

    @Override
    public String toString(){
        if(isEmpty())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T node : this)
            sb.append(node).append(", ");
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularSinglyLinkedListIterator<T>(head);
    }

    private class CircularSinglyLinkedListIterator<T> implements Iterator<T> {

        private LinearNode<T> node;
        boolean visitingAgain;

        CircularSinglyLinkedListIterator(LinearNode<T> node) {
            this.node = node;
            visitingAgain = false;
        }

        @Override
        public boolean hasNext() {
            if(node == head && !visitingAgain)
                return true;
            else
                return false;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            T element = node.getElement();
            node = node.getNext();
            return element;
        }
    }

    private void checkIndexInBounds(int index){
        if (index < 0 || index > count - 1)
            throw new IndexOutOfBoundsException("Index out of bounds");
    }

    private void checkElementNotNull(T element) {
        if (element == null)
            throw new IllegalArgumentException("Element cannot be null");
    }

}
