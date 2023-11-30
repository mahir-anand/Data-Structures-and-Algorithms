import java.util.LinkedList;
import java.util.*;

public class BinaryTrees {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class binaryTrees {
        static int i = -1;
        public static Node buildTree(int[] nodes) {
            i++;
            if (nodes[i] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[i]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }


        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } 
                    q.add(null);
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    } 
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }

        }

        public static int height (Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh,rh) + 1;
        }

        public static int countNodes (Node root) {
            if (root == null) {
                return 0;
            }
            int lc = countNodes(root.left);
            int rc = countNodes(root.right);

            return lc + rc + 1;

        }

        public static int sumOfNodes (Node root) {
            if (root == null) {
                return 0;
            }
            int ls = sumOfNodes(root.left);
            int rs = sumOfNodes(root.right);

            return ls + rs + root.data;

        }

        public static int diameter (Node root) {
            if (root == null) {
                return 0;
            }

            int ld = diameter(root.left);
            int rd = diameter(root.right);
            int lh = height(root.left);
            int rh = height(root.right);

            int self = lh + rh + 1;

            return Math.max(self,Math.max(ld, rd));

        }

    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; 
        binaryTrees tree = new binaryTrees();  
        Node root = tree.buildTree(nodes);
        System.out.println(tree.diameter(root));

    }

}
