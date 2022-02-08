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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        List<TreeNode> pre=new ArrayList<>();
        ntr(root,target,pre);
        for(int i=0;i<pre.size();i++){
            pkd(pre.get(i),k-i,ans,i==0?null:pre.get(i-1));
        }

        // pkd(target,k,ans);
        return ans;
        
    }
    public boolean ntr(TreeNode root, TreeNode target, List<TreeNode> ans){
        if(root==null){
            return false;
        }
        if(root==target){
            ans.add(root);
            return true;
        }
        boolean left=ntr(root.left,target,ans);
        if(left){
            ans.add(root);
            return true;
        }
        boolean right=ntr(root.right,target,ans);
        if(right){
            ans.add(root);
            return true;
        }
        return false;
    }
    public void pkd(TreeNode target, int k,List<Integer> ans,TreeNode block){
        if(target==null || k<0 || target==block) return;
        if(k==0){
            ans.add(target.val);
        }
        pkd(target.left,k-1,ans,block);
        pkd(target.right,k-1,ans,block);

    }
}