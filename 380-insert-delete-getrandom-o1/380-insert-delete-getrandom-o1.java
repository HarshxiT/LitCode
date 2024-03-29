class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer,Integer> map;

    Random r;
    public RandomizedSet() {
        r=new Random();
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))return false;
        int loc=map.get(val);
        int last=list.get(list.size()-1);
        map.put(last,loc);
        list.set(loc,last);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        int n=r.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */