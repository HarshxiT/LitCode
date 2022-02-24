class Solution {
    public int countSubstrings(String s) {
        return subs(s,0);
    }
    public int subs(String str,int i){
        if(i==str.length()){
            return 0;
        }
        int c=0;
        for(int j=str.length();j>i;j--){
            String a=str.substring(i,j);
            if(palin(a)){
                c++;
            }
        }
        c+=subs(str,i+1);
        return c;
    }
    public boolean palin(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}