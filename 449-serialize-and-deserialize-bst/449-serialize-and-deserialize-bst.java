/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "null,";
        String res= root.val+","+ serialize(root.left)+ serialize(root.right);
        // System.out.println(res);
        return res;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        i=0;
        return helper(arr);
    }
    int i;
    private TreeNode helper(String[] arr){
        if(arr[i].equals("null")){
            i++;
            return null;
        }
        System.out.print(arr[i]+" ");
        TreeNode root=new TreeNode(Integer.parseInt(arr[i]));
        i++;
        root.left=helper(arr);
        root.right=helper(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;