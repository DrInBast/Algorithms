/*
 * 不同类型的元素
 * 编写测试用例，生成有多种数据类型元素组成的数组，元素主键随机。
 *  1.元素主键为 String 类型。
 *  2.元素主键为 double 类型，并含有 10 个 String 值。
 *  3.元素主键为 int 类型，并含有 1 个 int[20] 的值。
 */

package Exercises.E2_1_38;

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
            
        else if (distribution.equals("2"))
            
        else if (distribution.equals("3")) {
            

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
