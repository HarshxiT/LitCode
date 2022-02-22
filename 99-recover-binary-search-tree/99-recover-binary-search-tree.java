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
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        first=null;
        second=null;
        prev=null;
        traverse(root);
        
        int s=first.val;
        first.val=second.val;
        second.val=s;
    }
    private void traverse(TreeNode root) {
        
        if (root == null)
            return;
            
        traverse(root.left);
        
        // Start of "do some business", 
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (prev!=null && first == null && prev.val >= root.val) {
            first = prev;
        }
    
        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (first != null && prev.val >= root.val) {
            second = root;
        }        
        prev = root;

        // End of "do some business"

        traverse(root.right);
}
}