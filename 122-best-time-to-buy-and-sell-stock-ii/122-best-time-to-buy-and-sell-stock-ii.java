class Solution {
    public int maxProfit(int[] prices) {
        int p=0;
        int s=prices[0];
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]>prices[i+1]){
                p+=(prices[i]-s);
                s=prices[i+1];
            }
        }
        if(prices[prices.length-1]>s){
            p+=(prices[prices.length-1]-s);
        }
        return p;
    }
}