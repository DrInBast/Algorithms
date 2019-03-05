/*
 * 不需要交换的插入排序
 * 在插入排序的实现中使较大的元素怒右移一位只需要访问一次数组（不使用 exch()）。
 */

package Exercises.E2_1_25;

import StdLibrary.*;

public class InsertionSort_WithoutExches {
    public static void sort (Comparable[] a) {
        for(int i = 1; i < a.length; i ++) {
            Comparable v = a[i];
            int j = i;
            while(j > 0 && less(v, a[j - 1]))
                a[j] = a[-- j];
            a[j] = v;
        }

    }      

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