class Solution {
    public int reverse(int x) {
        int res=0;
        while(x!=0){
            int t=x%10;
            int nres=res*10+t;
            if((nres-t)/10!=res){
                return 0;
            }
            res=nres;
            x/=10;
        }
        return res;
    }
}