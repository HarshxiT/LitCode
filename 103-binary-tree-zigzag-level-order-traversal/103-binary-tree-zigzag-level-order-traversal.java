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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        LinkedList<TreeNode> q=new LinkedList<>();
        q.addLast(root);
        boolean f=true;
        while(q.size()>0){
            int s=q.size();
            List<Integer> res=new ArrayList<>();
            while(s-->0){
                TreeNode rem=q.removeFirst();
                if(f)
                res.add(rem.val);
                else res.add(0,rem.val);
                if(rem.left!=null)q.addLast(rem.left);
                if(rem.right!=null)q.addLast(rem.right);
            }
            ans.add(res);
            f = f ? false : true;
        }
        return ans;
    }
}