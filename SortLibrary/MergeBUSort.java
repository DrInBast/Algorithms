package SortLibrary;

import StdLibrary.*;

public class MergeBUSort {
    private static Comparable[] aux;

    public static void merge (Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for(int k = lo; k < hi; k ++)
            aux[k] = a[k];
        
        for(int k = lo; k <= hi; k ++)
            if(i > mid) a[k] = aux[j ++];
            else if(j > hi) a[k] = aux[i ++];
            else if(less(aux[j], aux[i])) a[k] = aux[j ++];
            else a[k] = aux[i ++];
    }

    public static void sort (Comparable[] a) {
        aux = new Comparable [a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort (Comparable[] a, int lo, int hi) {
        if(lo >= hi) return ;
        
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    // 自底向上的归并排序
    // public static void sort (Comparable[] a) {
    //     aux = new Comparable [a.length];
    //     for(int sz = 1; sz < a.length; sz = sz + sz)
    //         for(int lo = 0; lo < a.length - sz; lo += sz + sz)
    //             merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
    // }

    private static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch (Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show (Comparable[] a) {
        for(int i = 0; i < a.length; i ++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    private static boolean isSorted (Comparable[] a) {
        for(int i = 0; i < a.length; i ++)
            if(less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static void main (String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}