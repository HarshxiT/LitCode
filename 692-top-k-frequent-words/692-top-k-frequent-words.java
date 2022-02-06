class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        ArrayList<String> arr=new ArrayList<>(map.keySet());
        Collections.sort(arr,(a,b)->{
           if(map.get(a)==map.get(b)){
               return a.compareTo(b);
           }
            return map.get(b)-map.get(a); 
        });
        List<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++)ans.add(arr.get(i));
        return ans;
    }
}