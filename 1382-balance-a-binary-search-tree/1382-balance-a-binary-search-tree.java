/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        
        ArrayList<Integer> seq = new ArrayList<>();
        
        inOrder(root, seq);
        
        return build(seq,0,seq.size()-1);
        
    }
    
    public TreeNode build (ArrayList<Integer> seq,int start,int end) {
        
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(seq.get(mid));
        
        root.left = build(seq,start,mid-1);
        root.right = build(seq,mid+1,end);
        
        return root;
        
    }
    
    public void inOrder (TreeNode root, ArrayList<Integer> seq) {
        
        if (root == null) {
            return;
        }
        
        inOrder(root.left, seq);
        seq.add(root.val);
        inOrder(root.right, seq);
        
        
    }
}