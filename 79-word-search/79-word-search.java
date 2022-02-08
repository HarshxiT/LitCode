class Solution {
    int[] di={0,0,-1,1};
    int[] dj={1,-1,0,0};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!=word.charAt(0)) continue;
                boolean res=find(board,i,j,0,word);
                if(res){
                    return res;
                }
            }
        }
        return false;
    }
    public boolean find(char[][] board, int i,int j,int k,String word){
        if(k==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(k)){
            return false;
        }
        char mychar=board[i][j];
        board[i][j]='@';
        for(int l=0;l<4;l++){
            boolean res=find(board,i+di[l],j+dj[l],k+1,word);
            if(res){
                board[i][j]=mychar;
                return true;
            }
        }
        board[i][j]=mychar;
        return false;
    }
}