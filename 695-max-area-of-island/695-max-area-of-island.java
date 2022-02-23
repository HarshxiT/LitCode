class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        boolean[][] vst=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==1 && vst[i][j]!=true){
                   max=Math.max(dfs(i,j,grid,vst),max);
               }
           } 
        }
        // if(max==Integer.MIN_VALUE)return 0;
        return max;
    }
    int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int dfs(int i,int j,int[][] grid,boolean[][] vst){
        vst[i][j]=true;
        int m=1;
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1 && vst[x][y]!=true){
                m+=dfs(x,y,grid,vst);
            }
        }
        return m;
    }
}