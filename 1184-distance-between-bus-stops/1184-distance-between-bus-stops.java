class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int a=0;
        if(start<destination){
            for(int i=start;i<destination;i++){
            a+=distance[i];
        }
            
        }
        else{
                for(int i=start;i<destination+distance.length;i++){
            a+=distance[i%distance.length];
        }
            }
        
        int b=0;
        for(int i=0;i<distance.length;i++){
            b+=distance[i];
        }
        return Math.min(a,b-a);
    }
}