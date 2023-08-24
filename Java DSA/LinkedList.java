public class LinkedList {

    public static class Node {

        int data;
        Node next;
        
        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst (int data) {

        Node newNode = new Node (data);
        size++; // create a new node

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head; // link the new node to the head
        head = newNode; // set the new node as the head node
    }

    public void addLast (int data) {

        Node newNode = new Node (data);
        size++;

        if (head == null) {
            tail = head = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void print() {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node (data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }    

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Already Empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("Already Empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for (int i = 0 ; i < size - 2 ; i ++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        size--;
        tail = prev;
        return val;

    }

    public int iterativeSearch (int key) {
        Node temp = head;
        for (int i = 0 ; i < size ; i++) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public int recursiveSearch (Node head, int key, int index) {

        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return index;
        }

        return recursiveSearch(head.next, key, index+1);

    }

    public void reverse () {
        Node prev = null;
        Node curr = tail = head; 
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void deleteFromEnd (int n) {
        //calculate size
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (n == size) {
            head = head.next;
            return;
        }

        int i = 1;
        int index = size - n; // index of the previous node
        Node prev = head;
        while (i < index) {
            i++;
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return;

    }

    public Node findMiddle (Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public boolean palindrome () {

        //corner case
        if (head == null || head.next == null) {
            return true;
        }

        // find the middle element
        Node mid = findMiddle(head);

        //reverse the second half
        Node prev = null;
        Node curr = mid;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node rightHead = prev;

        // check for palindrome
        while (rightHead != null) {
            if (head.data != rightHead.data) {
                return false;
            }
            head = head.next;
            rightHead = rightHead.next;
        }

        return true;
    }

    public static boolean cycle () {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        head = new Node (1);
        head.next = new Node (2);
        head.next.next = new Node (3);
        head.next.next.next = head;
        System.out.println(ll.cycle());

    }
    
}
