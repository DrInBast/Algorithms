/*
 * 不均匀的概率分布
 * 编写测试用例，使用非均匀分布的概率生成随机排列的数据，包括：高斯分布、泊松分布、几何分布、离散分布。
 */

package Exercises.E2_1_35;

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

        if (distribution.equals("gaussian")) {
            for(int t = 0; t < T; t ++) {
                for(int i = 0; i < N; i ++) {
                    a[i] = (double) StdRandom.gaussian();
                }
                total += time(alg, a);
            }
        } else if (distribution.equals("poisson")) {
            for(int t = 0; t < T; t ++) {
                for(int i = 0; i < N; i ++) {
                    a[i] = (double) StdRandom.poisson(1);
                }
                total += time(alg, a);
            }
        } else if (distribution.equals("geometric")) {
            for(int t = 0; t < T; t ++) {
                for(int i = 0; i < N; i ++) {
                    a[i] = (double) StdRandom.geometric(0.5);
                }
                total += time(alg, a);
            }
        } else if (distribution.equals("discrete")) {
            for(int t = 0; t < T; t ++) {
                for(int i = 0; i < N; i ++) {
                    double[] probabilities = {0.0};
                    a[i] = (double) StdRandom.discrete(probabilities);
                }
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