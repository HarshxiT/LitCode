class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=-1;
        // int j=-1;
        int sum=0;
        map.put(0,1);
        int ans=0;
        while(i<nums.length-1){
            i++;
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
        
    }
}