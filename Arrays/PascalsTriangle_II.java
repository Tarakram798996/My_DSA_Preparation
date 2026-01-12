package Arrays;
import java.util.*;
public class PascalsTriangle_II {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        long prev=1;
        for(int i=1;i<=rowIndex;i++){
            long next=prev*(rowIndex-i+1)/i;
            res.add((int)next);
            prev=next;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = getRow(5);
        System.out.println(res);
    }
}
