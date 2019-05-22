/*
 * 罕见情况
 * 编写测试用例，调用 sort() 方法对实际应用中可能出现的困难或者极端情况的数组进行排序。
 * 比如：顺序、逆序、所有元素主键相同、每个元素的主键只可能有两种取值, 数组大小为 0 或 1。
 */

package Exercises.E2_1_34;

import StdLibrary.*;
import SortLibrary.*;

public class SortTest {
    public static double time (String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();

        if (alg.equals("Insertion")) InsertionSort.sort(a);
        if (alg.equals("Selection")) SelectionSort.sort(a);
        if (alg.equals("ShellSort")) ShellSort.sort(a);

        return timer.elapsedTime();
    }

    public static double timeRandomInput (String distribution, String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double [N];

        if (distribution.equals("inorder")) {
            for(int t = 0; t < T; t ++) {
                a[0] = StdRandom.uniform();
                for(int i = 1; i < N; i ++)
                    a[i] = (double) StdRandom.uniform(a[i - 1], 1);
                total += time(alg, a);
            }
        } else if (distribution.equals("reserveredorder")) {
            for(int t = 0; t < T; t ++) {
                a[0] = StdRandom.uniform();
                for(int i = 1; i < N; i ++)
                    a[i] = (double) StdRandom.uniform(0, a[i - 1]);
                total += time(alg, a);
            }
        } else if (distribution.equals("1primarykey")) {
            for(int t = 0; t < T; t ++) {
                a[0] = StdRandom.uniform();
                for(int i = 1; i < N; i ++)
                    a[i] = a[i - 1];
                total += time(alg, a);
            }
        } else if (distribution.equals("2primarykeys")) {
            for(int t = 0; t < T; t ++) {
                for(int i = 0; i < N; i ++)
                    a[i] = (double) StdRandom.uniform(2);
                total += time(alg, a);
            }
        } else if (distribution.equals("arraylenth0or1")) {
            for(int t = 0; t < T; t ++) {
                int n = StdRandom.uniform(2);
                a = new Double [n];
                for (int i = 0; i < n; i ++)
                    a[i] = StdRandom.uniform();
                total += time(alg, a);
            }
        }

        return total;
    }

    public static void main (String[] args) {
        String distribution = args[0];
        String alg = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);

        double t1 = timeRandomInput(distribution, alg, N, T);

        StdOut.printf("For %d random Doubles from a %s distribution\n", N, distribution);
        StdOut.println(alg + " : " + t1);
    }
}