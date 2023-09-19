import java.util.*;
import java.util.LinkedList;

public class Queues {
    
    public static void interleave (Queue<Integer> q) {

        Queue<Integer> first = new LinkedList<>();
        
        int size = q.size();
        for (int i = 0 ; i < size / 2 ; i++) {
            first.add(q.remove());
        }

        while (!first.isEmpty()) {
            q.add(first.remove());
            q.add(q.remove());
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

        interleave(q);
        for (int i : q) {
            System.out.print(i + " ");
        }
       
    }

}
