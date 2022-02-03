class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,ArrayList<Integer>>bn=new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                bn.putIfAbsent(routes[i][j],new ArrayList<>());
                bn.get(routes[i][j]).add(i);
            }
        }
        LinkedList<Integer>q=new LinkedList<>();
        HashSet<Integer> vbn=new HashSet<>();
        HashSet<Integer> vbs=new HashSet<>();
        
        q.addLast(source);
        vbs.add(source);
        int ans=-1;
        while(q.size()>0){
            ans++;
            int s=q.size();
            while(s-->0){
                int rem=q.removeFirst();
                if(rem==target) return ans;
                for(int i:bn.get(rem)){
                    if(vbn.contains(i))continue;
                    for(int j:routes[i]){
                        if(vbs.contains(j))continue;
                        vbs.add(j);
                        q.addLast(j);
                    }
                    vbn.add(i);
                }
            }
        }
        return -1;
    }
}