class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        HashMap<Character,Integer> tmap=new HashMap<>();
        for(char ch:t.toCharArray()){
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }
        int des=t.length();
        int cur=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int i=-1;
        int j=-1;
        String ans="";
        while(true){
            boolean f1=true;
            boolean f2=true;
            while(i<s.length()-1 && cur<des){
                f1=false;
                i++;
                char ch=s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)<=tmap.getOrDefault(ch,0)){
                    cur++;
                }
            }
            while(j<i && cur==des){
                f2=false;
                j++;
                String res=s.substring(j,i+1);
                if(ans.equals("") || ans.length()>res.length())ans=res;
                char ch=s.charAt(j);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)<tmap.getOrDefault(ch,0)){
                    cur--;
                }
                if(map.get(ch)==0)map.remove(ch);
            }
            if(f1 && f2)break;
        }
        return ans;
    }
}