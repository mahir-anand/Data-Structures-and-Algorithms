import java.util.ArrayList;

public class Permutations {

    public static ArrayList<String> perm (String str, String ans) {

        if (str.isEmpty()) {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(ans);
            return temp;
        }

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0 ; i < str.length() ; i++) {
            list.addAll (perm (str.substring(0,i) + str.substring(i+1), ans + str.charAt(i)) );
        }

        return list;
    }
    public static void main (String args[]) {
        String str = "abc";
        System.out.println(perm(str, ""));
    }
    
}
