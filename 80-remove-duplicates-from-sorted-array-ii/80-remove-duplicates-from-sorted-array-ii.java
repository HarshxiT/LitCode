class Solution {
    public int removeDuplicates(int[] nums) {
        int ln=nums[0];
        int c=1;
        int k=1;
        for (int i=1;i<nums.length;i++){
            if(nums[k]==ln){
                if(c==2){
                    for(int j=k;j<nums.length-1;j++){
                        int n=nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=n;
                    }
                }else{
                    k++;
                    c++;
                }
            }
            else{
                ln=nums[k];
                c=1;
                k++;
            }
        }
        return k;
    }
}