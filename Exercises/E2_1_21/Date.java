package Exercises.E2_1_21;

public class Date implements Comparable<Date> {
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

    public int compareTo (Date another) {
        if(year > another.year) return 1;
        if(year < another.year) return -1;
        if(month > another.month) return 1;
        if(month < another.month) return -1;
        if(day > another.day) return 1;
        if(day < another.day) return -1;
        return 0;
    }

    @Override
    public String toString () {
        return month + "/" + day + "/" + year;
    }
}