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

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int min = i;
            
            if (left < arr.size() && arr.get(left) < arr.get(min)) {
                min = left;
            }

            if (right < arr.size() && arr.get(right) < arr.get(min)) {
                min = right;
            }

            if (min != i) {
                int temp = arr.get(i);
                arr.set(i,arr.get(min));
                arr.set(min,temp);

                heapify(min);
            }

        }

        public int delete() {
            int data = arr.get(0);
            //swap
            int temp = arr.get(0); 
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
            
            //delete last
            arr.remove(arr.size()-1);

            //heapfiy
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        public static void heapSort (int[] arr) {
            
            //max heap
            int n = arr.length;
            for (int i = n/2 ; i >=0 ; i--) {
                heapify2(i,n,arr);
            }

            //push largest at end
            for (int i = n - 1 ; i >=0 ; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify2(0,i,arr);
            }
        }

        public static void heapify2 (int i, int n, int[] arr) {
            
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int max = i;

            if (left < n && arr[left] > arr[max]) {
                max = left;
            }

            if (right < n && arr[right] > arr[max]) {
                max = right;
            }

            if (max != i) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;

                heapify2(max, n, arr);
            }

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
        
        int[] arr = {1,2,4,5,3};
        Heap.heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
    
}
