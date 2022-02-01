class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        boolean[][] vst=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vst[i][j]==false && grid[i][j]=='1'){
                    ans++;
                    dfs(i,j,grid,vst);
                }
            }
        }
        return ans;
    }
    int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};
    public void dfs(int i,int j,char[][] grid, boolean[][] vst) {
        vst[i][j]=true;
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]=='0' || vst[x][y]==true)continue;
            dfs(x,y,grid,vst);

        }
    }

}