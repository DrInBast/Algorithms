/*
 * 原始数据类型
 * 编写一个能够处理 int 值的插入排序新版本。
 */

package Exercises.E2_1_26;

import StdLibrary.*;

public class InsertionSort_Int {
    public static void sort (Comparable[] a) {
        for (int i = 1; i < a.length; i ++)
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j --)
                exch(a, j, j - 1);
    }
    
    public static void sort (int[] a) {
        for(int i = 1; i < a.length; i ++)
            for(int j = i; j > 0 && a[j] < a[j - 1]; j --)
                exch(a, j, j - 1);
    }

    private static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch (Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void exch (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show (Comparable[] a) {
        for(int i = 0; i < a.length; i ++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    private static void show (int[] a) {
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

    private static boolean isSorted (int[] a) {
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

        int[] b = In.readInts();
        sort(b);
        assert isSorted(b);
        show(b);
    }

}
