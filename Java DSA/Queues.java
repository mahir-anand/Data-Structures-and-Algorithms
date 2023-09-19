import java.util.*;
import java.util.LinkedList;

public class Queues {
    
    public static void reverse (Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.remove());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }

    public static void main(String[] args) {
       
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        reverse(q);
        for (int i : q) {
            System.out.print(i + " ");
        }
       
    }

}
