import java.util.*;
import java.util.LinkedList;

public class Queues {

    static class Queue {

        static Deque<Integer> de = new LinkedList<>();

        public static boolean isEmpty() {
            return de.isEmpty();
        }

        public static void add(int data) {
            de.addLast(data);
        }

        public static int remove() {
            int top = de.peek();
            de.removeFirst();
            return top;
        }

        public static int peek() {
            return de.peek();
        }

    }
    public static void main(String[] args) {
       
       Queue q = new Queue();
       q.add(1);
       q.add(2);
       q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
       
    }

}
