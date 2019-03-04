/*
 * 为 Date 类编写能够解析字符串数据的构造函数，
 * 它接受一个 String 参数指定的初始值，格式如下：
 * 5/22/1939
 */

package Exercises.E1_2_19;

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
}