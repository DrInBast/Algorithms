/*
 * 双倍测试
 * 编写一个能够对排序算法进行双倍测试的用例。排序后打印实际排序用时和在 N 增倍后两次用时的比例。
 * 数组规模 N 的起始值为 1000 。
 * 用这段代码验证选择排序和插入排序的运行时间都是平方级别的。猜想希尔排序的性能并验证。
 */

package Exercises.E2_1_31;

import StdLibrary.*;
import SortLibrary.*;

public class DoubleTest {
    public static double time (String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();

        if(alg.equals("Insertion")) InsertionSort.sort(a);
        if(alg.equals("Selection")) SelectionSort.sort(a);
        if(alg.equals("Shell")) ShellSort.sort(a);

        return timer.elapsedTime();
    }

    public static double timeRandomInput (String alg, int N) {
        double total = 0.0;
        Double[] a = new Double [N];

        for (int t = 0; t < 1000; t ++) {
            for (int i = 0; i < N; i ++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }

        return total;
    }

    public static void main (String[] args) {
        String alg = args[0];

        int T = Integer.parseInt(args[1]);
        int N = Integer.parseInt(args[2]);

        double[] time = new double [T];
        int[] size = new int [T];

        for (int t = 0; t < T; t ++) {
            time[t] = timeRandomInput(alg, size[t] = N + t * N / 10);

            StdOut.println("t" + t + " : " + time[t]);

            int i = (size[t] / 2 - N) / (N / 10);
            if (size[t] % (N / 5) == 0 &&  i >= 0)
                StdOut.println("t" + t + " / " + "t" + i + " : " + time[t] / time[i]);
        }
    }
}