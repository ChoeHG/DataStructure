package sort;

public class Merge {
    //归并排序时间复杂度为 NlgN
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
//        aux = new Comparable[a.length];

        //将原数组复制到一个辅助数组中
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        /*
         * 进行归并时进行四个条件判断
         * 1.左边边用尽（取右半边的元素）
         * 2.右半边用尽（取左半边的元素
         * 3.右半边当前元素小于左半边的当前元素（取右半边的元素）
         * 4,右半边当前元素大于左半边的当前元素（取左半边的元素）
         */
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /*自顶向下的归并排序（分治思想）
    * 递归*/
    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid);//将左半边排序
        sort(a, mid + 1, high);//将右半边排序
        merge(a, low, mid, high);//归并结果
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
