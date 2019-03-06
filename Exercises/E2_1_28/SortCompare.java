/*
 * 相等的主键
 * 对于主键仅可能取两种值的数组，评估和验证插入排序和选择排序的性能。
 */

package Exercises.E2_1_28;

import StdLibrary.*;
import SortLibrary.*;

public class SortCompare {
    public static double time (String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();

        if (alg.equals("Insertion")) InsertionSort.sort(a);
        if (alg.equals("Selection")) SelectionSort.sort(a);

        return timer.elapsedTime();
    }

    public static double timeRandomInput (String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double [N];

        for(int t = 0; t < T; t ++) {
            for(int i = 0; i < N; i ++)
                a[i] = (double) StdRandom.uniform(2);
            total += time(alg, a);
        }

        return total;
    }

    public static void main (String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);

        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        StdOut.printf("For %d random Doubles\n", N);
        StdOut.println(alg1 + " : " + t1);
        StdOut.println(alg2 + " : " + t2);
    }
}
