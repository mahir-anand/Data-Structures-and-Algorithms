import java.util.*;
import java.util.LinkedList;

public class Queues {

    static class Stack {

        static Deque<Integer> de = new LinkedList<>();

        public static boolean isEmpty() {
            return de.isEmpty();
        }

        public static void push(int data) {
            de.addLast(data);
        }

        public static int pop() {
            int top = de.peekLast();
            de.removeLast();
            return top;
        }

        public static int peek() {
            return de.peekLast();
        }

    }
    public static void main(String[] args) {
       
       Stack s = new Stack();
       s.push(1);
       s.push(2);
       s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
       
    }

}
