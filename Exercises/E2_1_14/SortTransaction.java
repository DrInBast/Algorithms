/*
 * 编写 SortTransaction 类，将它们排序，并在标准输出中打印
 */

package Exercises.E2_1_22;

import StdLibrary.*;
import SortLibrary.*;
import Exercises.E2_1_21.*;

public class SortTransaction {
    public static Transaction[] readTransactoins () {
        Queue<Transaction> q = new Queue<Transaction>();

        while (StdIn.hasNextLine()) {
            q.enqueue(new Transaction(StdIn.readLine()));
        }

        int N = q.size(); // 必须定义 N 记录当下队列 q 的大小，因为队列 q 的大小是动态变化的
        Transaction[] a = new Transaction [N];
        for(int i = 0; i < N; i ++)
            a[i] = q.dequeue();

        return a;
    }

    public static void main (String[] args) {
        Transaction[] transactions = readTransactoins();
        
        for(Transaction t : transactions)
            StdOut.println(t);
        StdOut.println();

        ShellSort.sort(transactions);
        for(Transaction t : transactions)
            StdOut.println(t);
    }
}