import java.util.ArrayList;

public class Permutations {

    public static int perm (String str, String ans) {

        if (str.isEmpty()) {
            return 1;
        }

        int count = 0;

        for (int i = 0 ; i < str.length() ; i++) {
            count = count + perm (str.substring(0,i) + str.substring(i+1), ans + str.charAt(i));
        }

        return count;

      
    }
    public static void main (String args[]) {
        String str = "abc";
        System.out.println(perm(str, ""));
    }
    
}
