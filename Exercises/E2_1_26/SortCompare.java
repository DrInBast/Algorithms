/*
 * 使用 SortCompare 来比较这种能够处理 int 值的插入排序和能够隐式地使用自动装箱和拆箱转换 Integer 值的插入排序。
 */

package Exercises.E2_1_26;

import StdLibrary.*;

public class SortCompare {
    public static double time (String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();

        InsertionSort_Int.sort(a);

        return timer.elapsedTime();
    }

    public static double time (String alg, int[] a) {
        Stopwatch timer = new Stopwatch();

        InsertionSort_Int.sort(a);

        return timer.elapsedTime();
    }

    public static double timeRandomInput (String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double [N];
        int[] b = new int [N];

        if (alg.equals("Insertion")) {
            for (int t = 0; t < T; t ++) {
                for (int i = 0; i < N; i ++)
                    a[i] = StdRandom.uniform();
                total += time(alg, a);
            }
        }

        if (alg.equals("Insertion_Int")) {
            for (int t = 0; t < T; t ++) {
                for (int i = 0; i < N; i ++)
                    b[i] = (int) (StdRandom.uniform() * 100);
                total += time(alg, b);
            }
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

        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
