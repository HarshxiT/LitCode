class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i:nums){
            if(sum+i>=i){
                sum+=i;
            }
            else{
                sum=i;
            }
        max=Math.max(sum,max);
        }
        return max;

    }
}