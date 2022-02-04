/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node temp=head;
        while(temp!=null){
            Node n=new Node(temp.val);
            n.next=temp.next;
            temp.next=n;
            temp=n.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random=temp.random.next;
                // temp.random=null;
            }
            temp=temp.next.next;
        }
        Node nhead=head.next;
        temp=nhead;
        Node t=head;
        while(t!=null){
            t.next=t.next.next;
            if(temp.next!=null){
                temp.next=temp.next.next;
                temp=temp.next;
            }
            
            t=t.next;
        }
        return nhead;
        
        
        
    }
}