class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        ArrayList<Integer> keys=new ArrayList<>(map.keySet());
        Collections.sort(keys,(a,b)->{return map.get(b)-map.get(a);});
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=keys.get(i);
        }
        return res;
    }
}