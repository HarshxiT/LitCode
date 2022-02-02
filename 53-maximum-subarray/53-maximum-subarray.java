class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i:nums){
            if(sum+i>=i){
                sum+=i;
                max=Math.max(sum,max);
            }
            else{
                sum=i;
            }
        max=Math.max(sum,max);
        }
        max=Math.max(sum,max);
        return max;

    }
}