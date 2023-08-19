import java.util.ArrayList;

public class DiceRolls {

    public static ArrayList<String> roll (int target, String ans) {

        if (target == 0) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(ans);
            return temp;
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1 ; i <= 6 && i <= target ; i++) {
            list.addAll ( roll (target - i, ans + i) );
        }

        return list;

    }
    public static void main (String args[]) {
        int target = 4;
        System.out.println(roll(target,""));
    }
    
}
