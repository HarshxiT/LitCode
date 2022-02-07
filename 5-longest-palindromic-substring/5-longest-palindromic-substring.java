class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        String ans="";
        for(int g=0;g<s.length();g++){
            for(int i=0;i<s.length()-g;i++){
                if(g==0)dp[i][i+g]=true;
                else if(g==1)dp[i][i+g]=s.charAt(i)==s.charAt(i+g);
                else{
                    dp[i][i+g]=(s.charAt(i)==s.charAt(i+g) && dp[i+1][i+g-1]==true);
                }
                if(dp[i][i+g]){
                    ans=s.substring(i,i+g+1);
                }
            }
        }
        return ans;
    }
}