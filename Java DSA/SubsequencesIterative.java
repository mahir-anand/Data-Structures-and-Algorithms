import java.util.ArrayList;

public class SubsequencesIterative {

    public static ArrayList<String> subsequence (String str, String ans) {

        if (str.isEmpty()) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(ans);
            return temp;
        }

        char ch = str.charAt(0);
        ArrayList<String> take = subsequence(str.substring(1), ans + ch);
        ArrayList<String> leave = subsequence(str.substring(1), ans);

        take.addAll(leave);
        return take;
    }
    public static void main (String args[]) {
        String str = "aba";
        System.out.println(subsequence(str, ""));
    }
    
}
