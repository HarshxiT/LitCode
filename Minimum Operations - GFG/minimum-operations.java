// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        //code here.
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            if(2*i<=n)
            dp[i]=Math.min(dp[2*i],dp[i+1])+1;
            else dp[i]=dp[i+1]+1;
        }
        // for(int i:dp){
        //     System.out.print(i+" ");
        // }
        return dp[0];
    }
}