class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // HashSet<String>vst=new HashSet<>();
        LinkedList<String>q=new LinkedList<>();
        HashSet<String>wordlist=new HashSet<>();
        for(String s:wordList){
            if(s.equals(beginWord))continue;
            wordlist.add(s);
        }
        int lvl=0;
        q.addLast(beginWord);
        while(q.size()>0){
            int s=q.size();
            lvl++;
            while(s-->0){
                String rem=q.removeFirst();
                if(rem.equals(endWord)) return lvl;
                char[] word=rem.toCharArray();
                for(int i=0;i<word.length;i++){
                    char ch=word[i];
                    for(int j=0;j<26;j++){
                        word[i]=(char)('a'+j);
                        String w=new String(word);
                        if(wordlist.contains(w)){
                            wordlist.remove(w);
                            q.addLast(w);
                        }
                    }
                    word[i]=ch;
                }   
                
            }
        }
        return 0;
    }
}