class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(n,n,"",res);
        return res;
    }
    public void helper(int ob,int cb,String s, List<String> res){
        if(ob==0 && cb==0){
            res.add(s);
            return;
        }
        if(ob>0){
            helper(ob-1,cb,s+"(",res);
        }
        
        if(cb>ob){
            helper(ob,cb-1,s+")",res);
        }
    }
}