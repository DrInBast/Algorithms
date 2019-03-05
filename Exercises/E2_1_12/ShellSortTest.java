/*
 * 编写程序，对随机的 Double 数组进行希尔排序，验证该值是一个较小的常数。
 * 数组的大小按照 10 的幂次递增。
 */

package Exercises.E2_1_12;

import StdLibrary.*;

public class ShellSortTest {
    public static int cnt = 0;

    public static void sort (Comparable[] a) {
        int h = 1;
        while(h < a.length / 3) h = 3 * h + 1;
        while(h >= 1) {
            for(int i = h; i < a.length; i ++)
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                    cnt ++;
                }

            h /= 3;
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

        // 测试数组中每个元素带来的比较次数和数组大小的比值
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double [N];
        for(int i = 0; i < N; i ++)
            a[i] = StdRandom.uniform();

        sort(a);
        StdOut.println(cnt / N);
    }

}
