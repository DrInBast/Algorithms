/*
 * 不均匀的数据
 * 编写测试用例，生成不均匀的测试数据。
 *  1.一半 0 ，一半 1 。
 *  2.一半 0 ，1/4 1 ，1/4 2 。
 *  3.一半 0 ，一半随机 int 值。
 */

package Exercises.E2_1_36;

import StdLibrary.*;
import SortLibrary.*;

public class SortTest {
    public static double time (String alg, Integer[] a) {
        Stopwatch timer = new Stopwatch();

        if (alg.equals("Insertion")) InsertionSort.sort(a);
        if (alg.equals("Selection")) SelectionSort.sort(a);
        if (alg.equals("ShellSort")) ShellSort.sort(a);

        return timer.elapsedTime();
    }

    public static double timeRandomInput (String distribution, String alg, int N, int T) {
        double total = 0.0;
        Integer[] a = new Integer [N];
        
        if (distribution.equals("1"))
            for(int t = 0; t < T; t ++) {
                for(int i = 0; i < N / 2; i ++)
                    a[i] = 0;
                for(int i = N / 2; i < N; i ++)
                    a[i] = 1;

                //置乱器
                for(int i = N - 1; i >= 0; i --) {
                    int tmp = a[i], randomRank = StdRandom.uniform(i);
                    a[i] = a[randomRank];
                    a[randomRank] = tmp;
                }
                total += time(alg, a);
            }
        else if (distribution.equals("2"))
            for(int t = 0; t < T; t ++) {
                for(int i = 0; i < N / 2; i ++)
                    a[i] = 0;
                for(int i = N / 2; i < 3 * N / 4; i ++)
                    a[i] = 1;
                for(int i = 3 * N / 4; i < N; i ++)
                    a[i] = 2;
                
                for(int i = N - 1; i >= 0; i --) {
                    int tmp = a[i], randomRank = StdRandom.uniform(i);
                    a[i] = a[randomRank];
                    a[randomRank] = tmp;
                }
                total += time(alg, a);
            }
        else if (distribution.equals("3"))
            for(int t = 0; t < T; t ++) {
                for(int i = 0; i < N / 2; i ++)
                    a[i] = 0;
                for(int i = N / 2; i < N; i ++)
                    a[i] = StdRandom.uniform(1000000);
                
                for(int i = N - 1; i >= 0; i --) {
                    int tmp = a[i], randomRank = StdRandom.uniform(i);
                    a[i] = a[randomRank];
                    a[randomRank] = tmp;
                }
                total += time(alg, a);
            }

            for(int i = N - 1; i >= 0; i --) {
                int tmp = a[i], randomRank = StdRandom.uniform(i);
                a[i] = a[randomRank];
                a[randomRank] = tmp;
            }
            total += time(alg, a);

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
