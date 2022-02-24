class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetH(nums,0,0);
    }
    public int subsetH(int[] nums,int i,int sum){
        if(i==nums.length){
            return sum;
        }
        int a=subsetH(nums,i+1,sum^nums[i]);
        int b=subsetH(nums,i+1,sum);
        return a+b;
    }
}