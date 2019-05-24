/*
 * 不均匀的数据
 * 编写测试用例，生成不均匀的测试数据。
 *  1.95% 有序，其余部分为随机值。
 *  2.所有元素与其正确位置的距离不超过 10。
 *  3.5% 的元素随机分布在数组中，剩下的元素有序。
 */

package Exercises.E2_1_37;

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
        
        if (distribution.equals("1"))
            for(int t = 0; t < T; t ++) {
                int n = (int) (N * 0.95);

                a[0] = StdRandom.uniform();
                for(int i = 1; i < n; i ++)
                    a[i] = (double) StdRandom.uniform(a[i - 1], 1);
                for(int i = n; i < N; i ++)
                    a[i] = (double) StdRandom.uniform();
                
                total += time(alg, a);
            }
        else if (distribution.equals("2"))
            for(int t = 0; t < T; t ++) {
                Integer[] distance = new Integer [N];

                a[0] = StdRandom.uniform();
                distance[0] = 0;
                for(int i = 1; i < N; i ++) {
                    a[i] = (double) StdRandom.uniform(a[i - 1], 1);
                    distance[i] = 0;
                }
                
                for(int i = N - 1; i >= 0; i --) {
                    
                    int left = i + distance[i] - 10,
                        right = i + distance[i] + 10,
                        randRank = StdRandom.uniform(Math.max(0, left), Math.min(right, N - 1));
                    
                    if (Math.abs(distance[randRank]) + Math.abs(i - randRank) < 10) {
                        Double tmp = a[i];      
                        a[i] = a[randRank];
                        a[randRank] = tmp;

                        Integer tmpD = distance[i];
                        distance[i] = distance[randRank];
                        distance[randRank] = tmpD;

                        distance[randRank] += i - randRank;
                        distance[i] += randRank - i;
                    }
                   
                }
                total += time(alg, a);
            }
        else if (distribution.equals("3")) {
            int n = (int) (N * 0.95);
            Double[] b = new Double [n];
            Double[] c = new Double [N - n];

            b[0] = StdRandom.uniform();
            for(int i = 1; i < n; i ++)
                b[i] = (double) StdRandom.uniform(a[i - 1], 1);
            for(int i = 0; i < N - n; i ++)
                c[i] = (double) StdRandom.uniform();

            int i = 0, j = 0, k = 0;
            while (j < n && k < N - n) {
                double flag = StdRandom.uniform();
                if (flag >= 0.5)
                    a[i ++] = b[j ++];
                else a[i ++] = c[k ++];
            } while (j < n) {
                a[i ++] = b[j ++];
            } while (k < N - n) {
                a[i ++] = c[k ++];
            }

            total += time(alg, a);
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
