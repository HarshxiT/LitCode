class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(int i[] : boxTypes){
            pq.offer(i);
        }
        int ans=0;
        // System.out.println(pq.poll()[1]);
        while(truckSize>0 && pq.size()>0){
            int[] rv=pq.poll();
            if(rv[0]>truckSize){
                ans+=(rv[1]*truckSize);
                truckSize=0;
            }
            else{
                ans+=(rv[0]*rv[1]);
                truckSize-=rv[0];
            }
        }
        return ans;
    }
}