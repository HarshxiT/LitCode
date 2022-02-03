class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:cpdomains){
            String[] a=s.split(" ");
            int n=Integer.parseInt(a[0]);
            String str=a[1];
            String ns="";
            for(int j=str.length()-1;j>=0;j--){
                char ch=str.charAt(j);
                if(ch=='.'){
                    map.put(ns,map.getOrDefault(ns,0)+n);
                }
                ns=ch+ns;
            }
            map.put(ns,map.getOrDefault(ns,0)+n);
        }
        List<String>ans=new ArrayList<>();
        for(String key:map.keySet()){
            String str=map.get(key)+" "+key;
            ans.add(str);
        }
        return ans;
    }
}