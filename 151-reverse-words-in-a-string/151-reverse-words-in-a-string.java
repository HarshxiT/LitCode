class Solution {
    public String reverseWords(String s) {
        String[] str=s.split(" ");
        String ans="";
        for(int i=str.length-1;i>=0;i--){
            if(str[i]=="")continue;
            ans+=str[i]+" ";
        }
        return ans.trim();
    }
}