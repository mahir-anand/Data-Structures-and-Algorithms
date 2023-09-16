import java.util.*;

public class Stacks {

    public static void printStack (Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static boolean validParentheses (String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                s.push(str.charAt(i));
            } else if (s.isEmpty()) {
                return false;
            } else if (str.charAt(i) == ')' && s.peek() == '(' || str.charAt(i) == ']' && s.peek() == '[' || str.charAt(i) == '}' && s.peek() == '{') {
                s.pop();
            } else {
                return false;
            }
        }

        if (!s.isEmpty()) {
            return false;
        }

        return true;

    }

    public static void main(String[] args) {
        String str = "({})[]";
        System.out.println(validParentheses(str));
    }

}
