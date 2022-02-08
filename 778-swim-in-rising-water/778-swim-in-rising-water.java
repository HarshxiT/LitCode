class Solution {
    class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        boolean[][] vst=new boolean[grid.length][grid[0].length];
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->grid[a.x][a.y]-grid[b.x][b.y]);
        q.offer(new pair(0,0));
        int t=Integer.MIN_VALUE;
        while(q.size()>0){
            pair rem=q.poll();
            if(vst[rem.x][rem.y])continue;
            vst[rem.x][rem.y]=true;
            t=Math.max(grid[rem.x][rem.y],t);
            if(rem.x==grid.length-1 && rem.y==grid[0].length-1){
                return t;
            }
            // if()
            for(int[] dir:dirs){
                int i=rem.x+dir[0];
                int j=rem.y+dir[1];
                if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vst[i][j]==true)continue;
                q.offer(new pair(i,j));
            }
        }
        return t;
        
    }
}