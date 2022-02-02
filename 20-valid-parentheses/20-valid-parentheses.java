class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> st=new LinkedList<>();
        // int r=0;
        // int sq=0;
        // int c=0;
        for(char ch:s.toCharArray()){

            if(ch=='(' || ch=='[' || ch=='{')st.addLast(ch);
            else if(st.size()==0)return false;
            else if(st.getLast()=='(' && ch==')')st.removeLast();
            else if(st.getLast()=='{' && ch=='}')st.removeLast();
            else if(st.getLast()=='[' && ch==']')st.removeLast();
            else return false;
        }
        if(st.size()==0)return true;
        return false;
    }
}