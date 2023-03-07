import java.util.*;

public class pairSum2 {
    
    public static boolean pairSum (ArrayList<Integer> list, int target) {
        int bp = -1;
        for (int i = 0 ; i < list.size() ; i ++) {
            if (list.get(i+1) < list.get(i)) {
                bp = i;
                break;
            }
        }

        int lp = bp + 1;
        int rp = bp; 
        int n = list.size();

        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) > target) {
                rp = (n+rp-1)%n;
            } else {
                lp = (lp+1)%n;
            }
        }
        return false;
    }

    public static void main (String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 17;
        System.out.println(pairSum(list, target));
    }

}
