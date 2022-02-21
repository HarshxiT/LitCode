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
    int max;
    boolean s;
    public boolean isValidBST(TreeNode root) {
        max=Integer.MIN_VALUE;
        s=true;
        return helper(root);
    }
    public boolean helper(TreeNode root){
        if(root==null)return true;
        if(!helper(root.left)) return false;
        if(root.val<=max && s==false)return false;
        max=root.val;
        s=false;
        if(!helper(root.right))return false;
        return true;
    }
}