import java.util.*;

public class Stacks {

    public static void printStack (Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static boolean duplicateParenthesis (String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) != ')') {
                s.push(str.charAt(i));
            } else {
                int count = 0;
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                }
                s.pop();
            }
        }
        return false;
    }

    

    public static void main(String[] args) {
        String str = "";
        System.out.println(duplicateParenthesis(str));
    }

}
