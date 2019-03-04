package SortLibrary;

import StdLibrary.*;

public class SelectionSort {
    public static void sort (Comparable[] a) {
        for(int i = 0; i < a.length; i ++) {
            int minRank = i;
            for(int j  = i + 1; j < a.length; j ++)
                if(less(a[j], a[minRank]))
                    minRank = j;
                exch(a, i, minRank);
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