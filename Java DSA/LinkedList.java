public class LinkedList {

    public static class Node {

        int data;
        Node next;
        
        public Node (int data) {
            this.data = data;
            this.next = null;
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

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
    }
    
}
