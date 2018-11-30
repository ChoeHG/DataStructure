package bag;

import java.util.Iterator;

public class Bag<E> implements Iterable<E> {
    private Node first;
    private class Node{
        E item;
        Node next;
    }

    public void add(E element) {
        Node oldFirst = first;
        first = new Node();
        first.item = element;
        first.next = oldFirst;
    }

    public Iterator<E> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {

        }

        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }

}
