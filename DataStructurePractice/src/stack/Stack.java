package stack;

public class Stack<E> {
    //使用链表实现栈
    private Node first;
    private int size;
    //内部类，私有类：不需要被实例化，并且可以调用外部类中的变量
    private class Node{
        E data;
        Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(E element) {
        Node oldFirst = first;
        first = new Node();
        first.data = element;
        first.next = oldFirst;
        size++;
    }

    public E pop() {
        E data = first.data;
        first = first.next;
        size--;
        return data;
    }
}
