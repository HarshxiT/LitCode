class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            ar.add(new ArrayList<Integer>());
            
        }
        int[] ind=new int[numCourses];
        for(int[] i:prerequisites){
            ar.get(i[1]).add(i[0]);
            ind[i[0]]++;
        }
        LinkedList<Integer> q=new LinkedList<>();
        for(int i=0;i<ind.length;i++){
            if(ind[i]==0){
                q.addLast(i);
            }
        }
        int idx=0;
        while(q.size()>0){
            idx++;
            int vt=q.removeFirst();
            for(int i:ar.get(vt)){
                ind[i]--;
                if(ind[i]==0){
                    q.addLast(i);
                }
            }
        }
        if(idx==numCourses){
            return true;
        }
        else{
            return false;
        }
    }
}