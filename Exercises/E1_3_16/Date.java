/*
 * 使用 1.3.1.5 节中的 readInts() 作为模板，为 Date 类编写静态方法 readDates()
 * 从标准输入中读取由练习 1.2.19 的表格所指定的格式的多日期并返回一个它们的数组
 */

package Exercises.E1_3_16;

import StdLibrary.*;

public class Date {
    private final int day;
    private final int month;
    private final int year;

    public Date (int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public Date (String date) {
        String[] ss = date.split("/");
        month = Integer.parseInt(ss[0]);
        day = Integer.parseInt(ss[1]);
        year = Integer.parseInt(ss[2]);

    }

    public int getDay () { return day; }
    public int getMonth () { return month; }
    public int getYear () { return year; }

    @Override
    public String toString () {
        return month + "/" + day + "/" + year;
    }

    // public static int[] readInts (String name) {
    //     In in = new In(name);
    //     Queue<Integer> q = new Queue<Integer>();

    //     while (!in.isEmpty()) {
    //         q.enqueue(in.readInt());
    //     }

    //     int[] a = new int [q.size()];
    //     for (int i = 0; i < q.size(); i ++)
    //         a[i] = q.dequeue();
    //     return a;
    // }

    public static Date[] readDates () {
        Queue<Date> q = new Queue<Date>();

        while (!StdIn.isEmpty()) {
            q.enqueue(new Date(StdIn.readString()));
        }

        int N = q.size();
        Date[] a = new Date [N];
        for(int i = 0; i < N; i ++) 
            a[i] = q.dequeue();
        return a;
    }
}