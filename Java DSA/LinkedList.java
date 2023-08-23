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

    public void addFirst (int data) {

        Node newNode = new Node (data); // create a new node

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head; // link the new node to the head
        head = newNode; // set the new node as the head node
    }

    public void addLast (int data) {

        Node newNode = new Node (data);

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

    

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
    }
    
}
