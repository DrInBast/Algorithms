/*
 *扩展 Transaction 类，实现 Comparable 接口，使金额能够按照金额排序
 */

package Exercises.E2_1_21;

public class Transaction implements Comparable<Transaction> {
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
    public double getAmount () { return amount;}

    public int compareTo (Transaction t) {
        if(amount < t.amount) return -1;
        else if(amount > t.amount) return 1;
        else return 0;
    }

    public String tosString () {
        return customer + " " + date.toString() + " " + amount;
    }
}