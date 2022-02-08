class MedianFinder {
    
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left=new PriorityQueue<Integer>(Collections.reverseOrder());
        right=new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(right.size()>0 && right.peek()<num){
            right.add(num);
        }
        else{
            left.add(num);
        }
        if(left.size()-right.size()==2){
            right.add(left.remove());
        }
        else if(right.size()-left.size()==2){
            left.add(right.remove());
        }
        
    }
    
    public double findMedian() {
        if(left.size()>right.size()){
            return left.peek()*1.0;
        }
        else if(right.size()>left.size()){
            return right.peek()*1.0;
        }
        else{
            return (left.peek() +right.peek() )*1.0/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */