public class LinkedList {

    public static Node head;
    public static Node tail;
    public static int size;

    public static class Node {

        int data;
        Node next;
        
        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

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

    public void recursiveAdd (int index, int val, Node curr) {

        if (index == 1) {
            Node newNode = new Node(val);
            Node temp = curr.next;
            curr.next = newNode;
            newNode.next = temp;
            return;
        }

        recursiveAdd(index-1, val, curr.next);
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

    public static void removeCycle () {
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        //finding the meeting node
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        
        //remove cycle
        fast.next = null;
    }

    public Node mergeSort (Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        //find the middle value
        Node mid = getMid(head);

        //recursive calls for left and right half
        Node right = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(right);

        //merge the sorted half
        return merge(newLeft, newRight);
    }

    public Node merge (Node newLeft, Node newRight) {

        Node mergedLL = new Node(-1); // auxiliary node
        Node temp = mergedLL; //pointer for sorted linked list

        while (newLeft != null && newRight != null) {
            if (newLeft.data < newRight.data) {
                temp.next = newLeft;
                newLeft = newLeft.next;
            } else {
                temp.next = newRight;
                newRight = newRight.next;
            }
            temp = temp.next;
        }

        while (newLeft != null) {
            temp.next = newLeft;
            newLeft = newLeft.next;
            temp = temp.next;
        }

        while (newRight != null) {
            temp.next = newRight;
            newRight = newRight.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node getMid(Node head) {

        if (head.next.next == null) {
            return head;
        }
        
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void zigzag () {
        //find mid
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        //reverse the second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextLeft; Node nextRight;

        //zig zag merge
        while (left != null && right != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
        
    }


    // Leetcode questions and patterns



    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.print();
        ll.recursiveAdd(3, 7, head);
        ll.print();


    }
    
}
