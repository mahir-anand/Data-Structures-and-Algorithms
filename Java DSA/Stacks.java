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

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(3);
        s.push(4);

        pushBottom(s, 1);
        
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    
    }

}
