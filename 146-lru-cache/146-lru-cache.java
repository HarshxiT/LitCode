class LRUCache {
    public class Node{
        int data;
        int key;
        Node next;
        Node prev;
        Node(int key, int data){
            this.key=key;
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    
    int capacity;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            remove(n);
            add(n);
            return n.data;
        }
        return  -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            n.data=value;
            remove(n);
            add(n);
        }
        else{
            if(map.size()<capacity){
                Node n=new Node(key,value);
                map.put(key,n);
                add(n);
            }
            else{
                Node n=new Node(key,value);
                map.put(key,n);
                add(n);
                int t=head.next.key;
                remove(head.next);
                map.remove(t);
            }
        }
    }
    public void remove(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
        n.next=null;
        n.prev=null;
    }
    public void add(Node n){
        n.prev=tail.prev;
        n.prev.next=n;
        n.next=tail;
        tail.prev=n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */