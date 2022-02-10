class MinStack {
    public class pair{
        int val;
        int min;
        pair(int val,int min){
            this.val=val;
            this.min=min;
        }
    } 
    Stack<pair> st;
    public MinStack() {
        st=new Stack<>(); 
    }
    
    public void push(int val) {
        if(st.size()==0)
        st.push(new pair(val,val));
        else{
        int currentMin = st.peek().min;
        st.push(new pair(val,Math.min(val,currentMin)));}
    }
    
    public void pop() {
        if(st.size()==0)return;
        st.pop();
    }
    
    public int top() {
        if(st.size()==0)return -1;
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */