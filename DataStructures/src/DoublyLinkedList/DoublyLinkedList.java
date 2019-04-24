package DoublyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements DoublyLinkedListADT<T>, Iterable<T>{

    private DoubleNode<T> head;
    private DoubleNode<T> rear;
    private int count;

    DoublyLinkedList(){
        head = null;
        rear = null;
        count = 0;
    }

    @Override
    public void addAsFirstElement(T element) {
        checkElementNotNull(element);
        DoubleNode<T> newNode = new DoubleNode<>(element);
        if(head == null){
            head = newNode;
            rear = head;
        }else{
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        count++;
    }

    @Override
    public void addAfter(int index, T element) {
        checkElementNotNull(element);
        checkIndexInBounds(index);
        DoubleNode<T> previousNode = getNode(index);
        DoubleNode<T> newNode = new DoubleNode<>(element);
        newNode.setNext(previousNode.getNext());
        newNode.setPrevious(previousNode);
        previousNode.setNext(newNode);
        count++;
    }

    @Override
    public void addAsLastElement(T element) {
        checkElementNotNull(element);
        DoubleNode<T> newNode = new DoubleNode<>(element);
        if(head == null){
            head = newNode;
            rear = head;
        } else {
            rear.setNext(newNode);
            newNode.setPrevious(rear);
            rear = newNode;
        }
        count++;
    }

    @Override
    public void set(int index, T element) {
        checkElementNotNull(element);
        getNode(index).setElement(element);
    }

    @Override
    public T get(int index) {
        return getNode(index).getElement();
    }

    @Override
    public T remove(int index) {
        checkIndexInBounds(index);
        DoubleNode<T> toRemove = getNode(index);
        if(index == 0){
            head = head.getNext();
        } else {
            toRemove.getPrevious().setNext(toRemove.getNext());
        }
        count--;
        return toRemove.getElement();
    }

    @Override
    public T removeElement(T element) {
        checkElementNotNull(element);
        int index = indexOf(element);
        if(index == -1)
            throw new IllegalStateException("Element not found");
        else
            return remove(index);
    }

    @Override
    public T removeLastElement() {
        if(isEmpty())
            throw new IllegalStateException("List is empty");
        DoubleNode<T> toRemove = rear;
        rear = rear.getPrevious();
        if(rear != null)
            rear.setNext(null);
        count--;
        return toRemove.getElement();
    }

    @Override
    public void clear() {
        head = null;
        rear = null;
        count = 0;
    }

    @Override
    public int indexOf(T element) {
        if (isEmpty())
            return -1;
        int index = 0;
        for (T item : this) {
            if (item.equals(element))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public DoubleNode<T> getNode(int index) {
        checkIndexInBounds(index);
        DoubleNode<T> result = head;
        for (int i = 0; i < index; i++) {
            result = result.getNext();
        }
        return result;
    }

    @Override
    public String forwardListTraversalString() {
        if(isEmpty())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<T> forwardIterator = iterator();
        while (forwardIterator.hasNext()){
            sb.append(forwardIterator.next().toString()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String reverseListTraversalString() {
        if(isEmpty())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<T> reverseIterator = reverseIterator();
        while(reverseIterator.hasNext()){
            sb.append(reverseIterator.next().toString()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString(){
        return forwardListTraversalString();
    }

    public Iterator<T> iterator(){
        return new DoublyLinkedListForwardIterator<T>(head);
    }

    public Iterator<T> reverseIterator(){
        return new DoublyLinkedListReverseIterator<T>(rear);
    }

    private class DoublyLinkedListForwardIterator<T> implements Iterator<T> {

        private DoubleNode<T> node;

        public DoublyLinkedListForwardIterator(DoubleNode<T> node){
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
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

    private class DoublyLinkedListReverseIterator<T> implements Iterator<T>{

        private DoubleNode<T> node;

        public DoublyLinkedListReverseIterator(DoubleNode<T> node){
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            T element = node.getElement();
            node = node.getPrevious();
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
