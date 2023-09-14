import java.util.*;

public class Stacks {
    
    public static void pushBottom (Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        
        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static void reverse (Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverse(s);
        pushBottom(s,top);

    }

    public static void printStack (Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    // public static String reverseString (String str) {
    //     Stack<Character> s = new Stack<>();
    //     int i = 0;
    //     while (i < str.length()) {
    //         s.push(str.charAt(i));
    //         i++;
    //     }

    //     StringBuilder result = new StringBuilder();
    //     while (!s.isEmpty()) {
    //         char top = s.pop();
    //         result.append(top);
    //     }

    //     return result.toString();
    // }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverse(s);
        printStack(s);
    }

}
