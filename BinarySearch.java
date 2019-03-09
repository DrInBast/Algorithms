import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import StdLibrary.*;

public class BinarySearch {
    public static int rank (int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) hi = mid - 1;
            else if(key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] whiteList = new In(args[0]).readAllInts();
        Arrays.sort(whiteList);

        // for(int i : whiteList) {
        //     System.out.println(i);
        // }
        
        BufferedReader bis = null;
        try {
            bis = new BufferedReader(new FileReader(args[1]));
            
            String s;
            while((s = bis.readLine()) != null) {
                //System.out.println(s.trim());
                int key = Integer.parseInt(s.trim());
                
                if(rank(key, whiteList) == -1)
                    StdOut.println(key);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis != null)
                    bis.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
            
        }
    }
}