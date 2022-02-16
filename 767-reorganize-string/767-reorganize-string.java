class Solution {
    private class Node {
        char ch;
        int num;
        public Node(char ch,int num){
            this.ch=ch;
            this.num=num;
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->(b.num-a.num));
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:map.keySet()){
            pq.add(new Node(ch,map.get(ch)));
        }
        StringBuilder ans=new StringBuilder();
        Node block=pq.poll();
        ans.append(block.ch);
        block.num--;
        while(pq.size()>0){
            Node temp=pq.poll();
            ans.append(temp.ch);
            temp.num--;
            if(block.num>0){
                pq.add(block);
            }
            block=temp;
        }
        if(block.num>0){
            return "";
        }
        return ans.toString();
        
        
    }
}