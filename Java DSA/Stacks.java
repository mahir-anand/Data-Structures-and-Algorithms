import java.util.*;

public class Stacks {
    
    // public static void pushBottom (Stack<Integer> s, int data) {
    //     if (s.isEmpty()) {
    //         s.push(data);
    //         return;
    //     }
        
    //     int top = s.pop();
    //     pushBottom(s, data);
    //     s.push(top);
    // }

    public static String reverseString (String str) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            s.push(str.charAt(i));
            i++;
        }

        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            char top = s.pop();
            result.append(top);
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(reverseString(s));
    }

}
