class Solution {
    public int calPoints(String[] ops) {
        ArrayList<Integer> rec=new ArrayList<>();
        for(String str:ops){
            if(str.equals("D")){
                rec.add(rec.get(rec.size()-1)*2);
            }
            else if(str.equals("+")){
                rec.add(rec.get(rec.size()-1)+rec.get(rec.size()-2));            }
            else if(str.equals("C")){
                rec.remove(rec.size()-1);
            }
            else{
                rec.add(Integer.parseInt(str));
            }
        }
        int sum=0;
        for(int i:rec){
            sum+=i;
        }
        return sum;
        
    }
}