/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    ArrayList<Integer> arr;
    int i;

    public NestedIterator(List<NestedInteger> nestedList) {
        arr=new ArrayList<>();
        i=0;
        helper(nestedList);
    }
    private void helper(List<NestedInteger> nestedList){
        for(NestedInteger ni:nestedList){
            if(ni.isInteger()){
                arr.add(ni.getInteger());
            }
            else{
                helper(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        i++;
        return arr.get(i-1);
        
    }

    @Override
    public boolean hasNext() {
        if(i<arr.size())return true;
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */