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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null)return true;

        if(root==null)return false;
        if(pre(root,subRoot) ||isSubtree(root.left,subRoot) ||isSubtree(root.right,subRoot))return true;
        return false;
    }
    public boolean pre(TreeNode root,TreeNode subRoot){
        if(subRoot==null && root==null)return true;
        if(subRoot==null || root==null)return false;
        
        if(root.val==subRoot.val && pre(root.left,subRoot.left) && pre(root.right,subRoot.right)){
            return true;
        }
        return false;
        
    }
}