/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        
        getPath(root, p, path1);
        getPath(root, q, path2);
        
        int itr = Math.min(path1.size(), path2.size());
        TreeNode ans = root;
        
        for (int i = 0 ; i < itr ; i++) {
            if (path1.get(i) == path2.get(i)) {
                ans = path1.get(i);
            }
        }
        
        return ans;
        
    }
    
    public boolean getPath(TreeNode root, TreeNode x, ArrayList<TreeNode> path) {
        
        if (root == null) {
            return false;
        }
        
        path.add(root);
        
        if (root.val == x.val) {
            return true;
        }
        
        
        boolean left = getPath(root.left,x,path);
        boolean right = getPath(root.right,x,path);
        
        if (left || right) {
            return true;
        }
        
        path.remove(path.size()-1);
        return false;
        
    }
    
}