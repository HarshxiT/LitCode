class Solution {
    public List<String> letterCombinations(String digits) {
        return letterH(digits,0);
    }
    String[] ans = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterH(String digits,int i){
        if(i==digits.length()){
            List<String> s=new ArrayList<>();
            return s;
        }
        List<String> a=letterH(digits,i+1);
        if(a.size()==0){
            a.add("");
        }
        List<String> s=new ArrayList<>();
        int d=Integer.parseInt(digits.charAt(i)+"");
        for(int j=0;j<ans[d].length();j++){
            char ch=ans[d].charAt(j);
            for(int k=0;k<a.size();k++){
                s.add(ch+a.get(k));
            }
        }
        return s;
    }
}