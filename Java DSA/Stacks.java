import java.util.ArrayList;

public class Stacks {
    
    static class node {
        int data;
        node next;
        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class stack {
        static node head = null;
        
        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            node temp = new node (data);
            temp.next = head;
            head = temp;
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int temp = head.data;
            head = head.next;
            return temp;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }



    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    
    }

}
