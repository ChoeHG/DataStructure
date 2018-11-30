package sort;

/*数据结构（二叉堆）能够很好的实现Priority queue
* 当一棵二叉树的每个节点都大于等于它的两个子节点时，它被称为堆有序
* 二叉堆时一组能够用堆有序的完全二叉树排序的元素，并在数组中按照层级储存（不使用数组的第一个位置）
* 在一个堆中，位置k的结点的父节点的位置为 k/2 ，而它的两个子节点的位置分别为2k和2k+1*/
public class MaxPQ<E extends Comparable<E>> {
    private E[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (E[]) new Comparable[maxN + 1];
    }

    public void insert(E v) {
        pq[++N] = v;
        swim(N);
    }

    public E max() {
        return null;
    }

    public E delMax() {
        E max = pq[1];
        exchange(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    //由下至上的堆有序化（上浮）
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }

    //由上至下的堆有序化（下沉）
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    private void exchange(int i, int j) {
        E temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
