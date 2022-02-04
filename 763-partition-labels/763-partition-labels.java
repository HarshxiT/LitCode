class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            last[ch-'a']=i;
        }
        int j=0;
        int anchor=0;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            j=Math.max(j,last[ch-'a']);
            if(i==j){
                ans.add(j-anchor+1);
                anchor=j+1;
            }
        }
        return ans;
        
    }
}