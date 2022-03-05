class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text2.length()+1][text1.length()+1];
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                if(text1.charAt(j)==text2.charAt(i)){
                    dp[i][j]=dp[i+1][j+1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
        
    }
}