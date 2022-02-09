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
        String str="";
        if(root==null){
            str+="null,";
        }
        else{
            str+=root.val+",";
            str+=serialize(root.left);
            str+=serialize(root.right);
        }
        System.out.println(str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String>q=new LinkedList<>();
        for(String str:data.split(",")){
            if(str=="")continue;
            q.addLast(str);
        }
        return help(q);
        
        
    }
    public TreeNode help(LinkedList<String> data){
        String s=data.removeFirst();
        if(s.equals("null")){
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(s));
        root.left=help(data);
        root.right=help(data);
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));