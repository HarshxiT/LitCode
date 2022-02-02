class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int i=-1;
        int j=-1;
        int max=0;
        while(true){
            boolean f1=false;
            boolean f2=false;
            while(i<s.length()-1){
                f2=true;
                i++;
                char ch=s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)==2)break;
                max=Math.max(max,i-j);
                // max=Math.max(max,set.size());
            }
            while(j<i){
                f1=true;
                j++;
                char ch=s.charAt(j);
                // if(ch==s.charAt(i))break;
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==1)break;
                map.remove(ch);
            }
            if(!f1 && !f2)break;
        }
        return max;
        
    }
}