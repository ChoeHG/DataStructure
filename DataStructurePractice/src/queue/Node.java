package queue;

public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E theData) {
        this.data = theData;
    }

    public Node(E theData, Node<E> theNext) {
        this.data = theData;
        this.next = theNext;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
