/*
 * 动画
 * 修改选择排序的 show() 代码，是算法在每一轮排序后重绘图片产生动画效果。
 */

package Exercises.E2_1_17;

import StdLibrary.*;

public class SelectionSort_Visualized {
    public static void sort (Comparable[] a) {
        for(int i = 0; i < a.length; i ++) {
            //show(a);
            
            int minRank = i;
            for(int j  = i + 1; j < a.length; j ++)
                if(less(a[j], a[minRank]))
                    minRank = j;
            exch(a, i, minRank);

            show(a);

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
        StdDraw.clear();

        StdDraw.setXscale(0, a.length);
        StdDraw.setYscale(0, 1);
        for(int i = 0; i < a.length; i ++) {
            double x = (double) i;
            double y = 0;
            double rw = 0.2;
            double rh = (double) a[i];
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    private static boolean isSorted (Comparable[] a) {
        for(int i = 0; i < a.length; i ++)
            if(less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static void main (String[] args) {
        int N = 100;
        Double[] a = new Double [N];
        for (int i = 0; i < N; i ++)
            a[i] = StdRandom.uniform();

        show(a);

        sort(a);
        assert isSorted(a);
    }

}