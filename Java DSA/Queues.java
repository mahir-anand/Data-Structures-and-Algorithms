import java.util.*;
import java.util.LinkedList;

public class Queues {
    
    public static void nonRepeating (String str) {

        int[] freq = new int [26];
        Queue<Character> characters = new LinkedList<>();
        
        for (int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i);
            characters.add(ch);
            freq[ch-'a']++;

            while (!characters.isEmpty() && freq[characters.peek() - 'a'] > 1) {
                characters.remove();
            }

            if (characters.isEmpty()) {
                System.out.print(-1);
            } else {
                System.out.print(characters.peek());
            }
            System.out.println();

        }

    }
    public static void main(String[] args) {
       
        String str = "aabccxb";
        nonRepeating(str);

    }

}
