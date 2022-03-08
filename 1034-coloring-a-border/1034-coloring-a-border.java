class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int oc=grid[row][col];
        change(grid,row,col,oc);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==-oc){
                    grid[i][j]=color;
                }
            }
        }
        return grid;
    }
    int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
    public void change(int[][] grid,int i,int j,int oc){
        grid[i][j]=-oc;
        int count=0;
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || Math.abs(grid[x][y])!=oc) continue;
            count++;
            if(grid[x][y]==oc){
                change(grid,x,y,oc);
            }
        }
        if(count==4) grid[i][j]=oc;
    }
}