/*
 * 希尔排序的用时是次平方级的
 * 用 SortCompare 比较希尔排序和插入排序以及选择排序。
 * 测试数组的大小按照 2 的幂次递增，从 128 开始。
 */

package Exercises.E2_1_27;

import StdLibrary.*;
import SortLibrary.*;

public class SortCompare {
    public static double time (String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();

        if(alg.equals("Insertion")) InsertionSort.sort(a);
        if(alg.equals("Selection")) SelectionSort.sort(a);
        if(alg.equals("Shell")) ShellSort.sort(a);

        return timer.elapsedTime();
    }

    public static double timeRandomInput (String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double [N];

        for(int t = 0; t < T; t ++) {
            for(int i = 0; i < N; i ++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }

        return total;
    }

    public static void main (String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        String alg3 = args[2];
        int N = Integer.parseInt(args[3]);
        int T = Integer.parseInt(args[4]);

        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        double t3 = timeRandomInput(alg3, N, T);

        StdOut.printf("For %d random Doubles\n", N);
        StdOut.printf(" %s is %.1f times faster than %s\n", alg1, t2 / t1, alg2);
        StdOut.printf(" %s is %.1f times faster than %s\n", alg1, t3 / t1, alg3);
    }
}
