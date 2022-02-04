class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // HashSet<String> ban=new HashSet<>();
        paragraph=paragraph.toLowerCase();
        char[] par=paragraph.toCharArray();
        HashMap<String,Integer> map=new HashMap<>();
        String ns="";
        for(char ch:par){
            if(Character.isLetter(ch)){
                ns+=ch;
            }
            else{
                if(ns=="")continue;
                map.put(ns,map.getOrDefault(ns,0)+1);
                ns="";
            }
        }
        if(ns!=""){
            map.put(ns,map.getOrDefault(ns,0)+1);
        }
        for(String str:banned){
            map.remove(str);
        }
        String ans="";
        int max=0;
        for(String s:map.keySet()){
            if(map.get(s)>max){
                max=map.get(s);
                ans=s;
            }
        }
        return ans;
        
    }
}