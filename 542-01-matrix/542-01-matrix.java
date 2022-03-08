class Solution {
    public class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<pair> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.addLast(new pair(i,j));
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        while(q.size()>0){
            pair rem=q.removeFirst();
            for(int[] dir:dirs){
                int x=rem.x+dir[0];
                int y=rem.y+dir[1];
                
                if(x>=0 && y>=0 && x<mat.length && y<mat[0].length && mat[x][y]==-1){
                    q.addLast(new pair(x,y));
                    mat[x][y]=mat[rem.x][rem.y]+1;
                }
            }
        }
        return mat;
    }
}