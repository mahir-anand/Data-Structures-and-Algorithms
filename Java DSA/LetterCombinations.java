import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public static List<String> letters (String str, String ans) {

        if (str.isEmpty()) {
            List<String> temp = new ArrayList<>();
            temp.add(ans);
            return temp;
        }

        char ch = str.charAt(0);
        int num = ch - '0';

        List<String> list = new ArrayList<>();

        if (num == 1) {
            list.addAll (letters(str.substring(1), ans));
            return list;
        }

        int start = (num - 2) * 3;
        int len = (num - 1) * 3;

        if (num >= 7) {
            len++;
        }

        if (num >= 8) {
            start++;
        }

        if (num == 9) {
            len++;
        }

        for (int i = start ; i < len ; i++) {
            list.addAll(letters(str.substring(1), ans + (char) ('a' + i)));
        }

        return list;
        
    }

    public static void main (String args[]) {
        String str = "23";
        System.out.println(letters(str, ""));
    }
    
}
