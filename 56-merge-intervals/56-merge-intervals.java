class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        ArrayList<int[]> ans=new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] c=intervals[i];
            int[] prev=ans.remove(ans.size()-1);
            if(c[0]<=prev[1]){
                if(c[1]>prev[1])
                prev[1]=c[1];
                ans.add(prev);
            }
            else{
                ans.add(prev);
                ans.add(c);
            }
        }
        int[][] res=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            res[i][0]=ans.get(i)[0];
            res[i][1]=ans.get(i)[1];
        }
        return res;
    }
}