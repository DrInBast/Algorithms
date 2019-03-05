/*
 * 为 Transaction 类编写能够解析字符串数据的构造函数，
 * 它接受一个 String 参数指定的初始值，格式如下：
 * Turing 5/22/1939 11.99。
 */

package Exercises.E1_3_17;

import StdLibrary.*;
import Exercises.E1_3_16.*;

public class Transaction {
    private final String customer;
    private final Date date;
    private final double amount;

    public Transaction (String s) {
        String[] ss = s.split(" ");
        customer = ss[0];
        date = new Date(ss[1]);
        amount = Double.parseDouble(ss[2]);
    }

    public String getCustomer () { return customer; }
    public String getDate () { return date.toString(); }
    public double getAmount () { return amount; }

    public String tosString () {
        return customer + " " + date.toString() + " " + amount;
    }

    public static Transaction[] readTransactoins () {
        Queue<Transaction> q = new Queue<Transaction>();

        while (!StdIn.isEmpty()) {
            q.enqueue(new Transaction(StdIn.readLine()));
        }

        int N = q.size();
        Transaction[] a = new Transaction [N];
        for(int i = 0; i < N; i ++) 
            a[i] = q.dequeue();
        return a;
    }
}
