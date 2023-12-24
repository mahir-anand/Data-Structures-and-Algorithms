import java.util.ArrayList;

public class BinarySearchTrees {
    

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
        }
    }

    public static Node insert (Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        } 

        if (root.data > val) {
            root.left = insert(root.left,val);
        } else {
            root.right = insert(root.right,val);
        }

        return root;
    }

    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left,val);
        } else if (root.data < val) {
            root.right = delete(root.right,val);
        } else {
            //leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            //single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //both children
            Node is = inorderSucc(root.right);
            root.data = is.data;
            root.right = delete(root.right,is.data);

        }

        return root;

    }
 
    public static Node inorderSucc(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static boolean search(Node root, int val) {
        
        if (root == null) {
            return false;
        }

        if (root.data == val) {
            return true;
        }

        if (root.data > val) {
            return search(root.left, val);
        } else {
            return search(root.right,val);
        }

    }

    public static void inorder(Node root) {
        
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void printRange(Node root, int k1, int k2) {
        
        if (root == null) {
            return;
        }
        
        if (root.data >= k1 && root.data <= k2) {
            printRange(root.left, k1, k2);
            System.out.println(root.data);
            printRange(root.right, k1, k2);
        } else if (root.data > k2) {
            printRange(root.left, k1, k2);
        } else {
            printRange(root.right, k1, k2);
        }
    }

    public static void rootToLeaf (Node root, ArrayList<Integer> path) {
        
        if (root == null) {
            return;
        }

        path.add(root.data);
        
        if (root.left == null && root.right == null) {
            for (int  i = 0 ; i < path.size() ; i++) {
                System.out.print(path.get(i) + " ");
            }
            System.out.println();
            path.remove(path.size() - 1);
            return;
        }
        
        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean validate (Node root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        return validate(root.left, min, root.data) && validate(root.right, root.data, max);

    }

    public static Node mirror (Node root) {
        
        if (root == null) {
            return root;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);

        return root;

    }

    public static void preOrder (Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String[] args) {
        // int[] values = {8,5,3,1,4,6,10,11,14};
        // Node root = null;

        // for (int i = 0 ; i < values.length; i++) {
        //     root = insert(root,values[i]);
        // }

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        preOrder(root);
        System.out.println();
        root = mirror(root);
        preOrder(root);



    }
}


