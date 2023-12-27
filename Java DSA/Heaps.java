import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heaps {


    static class Heap {
        
        ArrayList<Integer> arr = new ArrayList<>();

        public void add (int data) {
            arr.add(data);

            int x = arr.size() - 1; // child index
            int par = (x - 1) / 2; // parent index

            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x-1)/2;
            }

        }

        public void print () {
            for (int i = 0 ; i < arr.size() ; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }

        public int peek() {
            return arr.get(0);
        }

    }
    

    static class Student implements Comparable<Student> {
        
        String name;
        int rank;

        public Student (String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo (Student s2) {
            return this.rank - s2.rank;
        }

    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        h.add(1);
        h.print();
        System.out.println(h.peek());
    }
    
}
