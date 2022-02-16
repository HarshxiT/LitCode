class Solution {
    public int maxProfit(int[] prices) {
        int pr=0;
        int b=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>=b){
                pr=Math.max(pr,prices[i]-b);
            }
            else{
                b=prices[i];
            }
        }
        return pr;

    }
}