class Solution {
    public class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
    public int maxDistance(int[][] grid) {
        LinkedList<pair>q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    q.addLast(new pair(i,j));
                }
            }
        }
        if(q.size()==0 || q.size()==grid.length*grid.length)return -1;
        int count=-1;
        while(q.size()>0){
            int s=q.size();
            count++;
            while(s-->0){
                pair rem=q.removeFirst();
                for(int[] dir:dirs){
                    int x=rem.x+dir[0];
                    int y=rem.y+dir[1];
                    if(x<0 || y<0 || x>=grid.length || y>=grid.length || grid[x][y]==1)continue;
                    q.addLast(new pair(x,y));
                    grid[x][y]=1;
                }
            }
        }
        return count;
    }
}