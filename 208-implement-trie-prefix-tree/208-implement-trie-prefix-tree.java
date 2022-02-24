class Trie {
    
    class Node{
        Node[] words;
        boolean is;
        Node(){
            is=false;
            words=new Node[26];
        }
    }
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node temp=root;
        for(char ch:word.toCharArray()){
            if(temp.words[ch-'a']==null){
                temp.words[ch-'a']=new Node();
            }
            temp=temp.words[ch-'a'];
        }
        temp.is=true;
        
    }
    
    public boolean search(String word) {
        Node temp=root;
        for(char ch:word.toCharArray()){
            if(temp.words[ch-'a']==null){
                return false;
            }
            temp=temp.words[ch-'a'];
        }
        return temp.is;
        
    }
    
    public boolean startsWith(String word) {
        Node temp=root;
        for(char ch:word.toCharArray()){
            if(temp.words[ch-'a']==null){
                return false;
            }
            temp=temp.words[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */