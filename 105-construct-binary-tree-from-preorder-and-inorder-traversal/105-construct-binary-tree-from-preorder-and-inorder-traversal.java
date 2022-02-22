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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length-1,0,preorder.length-1);
    }
    public TreeNode helper(int[] preorder,int[] inorder,int ps, int pe, int is, int ie){
        if(ps>pe){
            return null;
        }
        int idx=is;
        while(preorder[ps]!=inorder[idx]){
            idx++;
        }
        int te=idx-is;
        TreeNode root=new TreeNode(preorder[ps]);
        root.left=helper(preorder,inorder,ps+1,ps+te,is,is+te-1);
        root.right=helper(preorder,inorder,ps+te+1,pe,is+te+1,ie);
        return root;
    }
}