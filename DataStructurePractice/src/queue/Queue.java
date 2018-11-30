package queue;

public class Queue<E> {
    private E[] list;
    private int first;
    private int firstFree;
    private int length;
    private static final int DEFAULT_MAXIMUM = 10;

    public Queue() {
        this.list = (E[]) new Object[DEFAULT_MAXIMUM];
    }

    public Queue(int size) {
        this.list = (E[]) new Object[size];
    }

    public void insert(E data) {
        if (firstFree == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        list[firstFree++] = data;
        if (firstFree == list.length) {
            firstFree = -1;
        }
        length++;
    }

    public E remove() {
        E removeItem = list[first];
        firstFree = first;
        list[first++] = null;
        length--;
        return removeItem;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public E getFront() {
        return list[first];
    }

    public int length() {
        return length;
    }

    public String toString() {
        for (E e : list) {
            System.out.println(e.toString());
        }
        return null;
    }
}
