class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int ocol=image[sr][sc];
        int[][] nimage=new int[image.length][image[0].length];
        dfs(image,nimage,sr,sc,newColor,ocol);
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(nimage[i][j]!=newColor){
                    nimage[i][j]=image[i][j];
                }
            }
        }
        return nimage;
    }
    int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(int[][] image,int[][] nimage,int i, int j,int ncol,int ocol){
        if(image[i][j]!=ocol)return;
        nimage[i][j]=ncol;
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>-1 && y>-1 && x<image.length && y<image[0].length && image[x][y]==ocol && nimage[x][y]!=ncol){
                dfs(image,nimage,x,y,ncol,ocol);
            }
        }
    }
}