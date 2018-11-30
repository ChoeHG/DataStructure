package stack;

import java.util.Iterator;

public class ResizingArrayStack<E> implements Iterable<E> {
    //下压栈，能动态调整数组大小的实现，使用数组实现
    private E[] arr = (E[]) new Object[1];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int max) {
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void push(E element) {
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size++] = element;
    }

    public E pop() {
        E element = arr[--size];
        arr[size] = null;
        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        return element;
    }

    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E> {
        private int i = size;

        public boolean hasNext() {
            return i > 0;
        }

        public E next() {
            return arr[--i];
        }

        public void remove() {

        }
    }

}
