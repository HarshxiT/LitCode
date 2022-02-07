class Solution {
    public boolean isRobotBounded(String instructions) {
        char[] dir={'w','n','e','s'};
        int d=1;
        int i=0;
        int j=0;
        for(char ch:instructions.toCharArray()){
            if(ch=='G'){
                if(d==1){
                    i++;
                }
                else if(d==3){
                    i--;
                }
                else if(d==2){
                    j++;
                }
                else j--;
            }
            else if(ch=='L'){
                d--;
                if(d<0)d+=4;
            }
            else{
                d++;
                if(d>=4)d%=4;
            }
        }
        return (i==0 && j==0)|| (d!=1);
        
    }
}