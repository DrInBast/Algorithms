package Exercises.E2_1_32;

import StdLibrary.*;
import SortLibrary.*;

public class TimeCurveGraph {
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
    public static void show(int T, int i, double t) {
        StdDraw.setXscale(0, T);
        StdDraw.setYscale(0, 10);
        StdDraw.setPenRadius(.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        
        StdDraw.point(i, t);
    }

    public static void main (String[] args) {
        String alg = args[0];

        int T = Integer.parseInt(args[1]);
        int N = Integer.parseInt(args[2]);

        for (int t = 1; t <= T; t ++) {
            double time = timeRandomInput(alg, N);

            N += t;

            show(T, t, time);
        }
    }
}