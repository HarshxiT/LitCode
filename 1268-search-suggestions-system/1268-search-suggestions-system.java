class Solution {
    private class Node{
        Node[] l;
        List<String> s;
        public Node(){
            l=new Node[26];
            s=new ArrayList<>();
        }
    }
    
    private void add(Node root,String word){
        char[] arr=word.toCharArray();
        // System.out.println(arr);
        Node temp=root;
        for(char ch:arr){
            if(temp.l[ch-'a']==null){
                temp.l[ch-'a']=new Node();
            }
            temp=temp.l[ch-'a'];
            if(temp.s.size()<3)
                temp.s.add(word);
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans=new ArrayList<>();
        Node root=new Node();
        Arrays.sort(products);
        for(String s:products){
            add(root,s);
        }
        Node n=root;
        for(int i=0;i<searchWord.length();i++){
            n=n.l[searchWord.charAt(i)-'a'];
            if(n==null){
                for(int j=i;j<searchWord.length();j++){
                    ans.add(new ArrayList<>());
                }
                break;
            }
            ans.add(n.s);
        }
        
        return ans;
    }
}