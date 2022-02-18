/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode nhead;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        nhead=null;
        int s1=size(l1);
        int s2=size(l2);
        int c=nhelper(l1,l2,s1,s2);
        if(c>0){
            ListNode n=new ListNode(c%10);
            n.next=nhead;
            nhead=n;
        }
        return nhead;
        

    }
    public int nhelper(ListNode l1,ListNode l2,int s1,int s2){
        if(s1>s2){
            int c=nhelper(l1.next,l2,s1-1,s2);
            int v=l1.val+c;
            ListNode n=new ListNode(v%10);
            n.next=nhead;
            nhead=n;
            c=v/10;
            return c;
            
        }
        else if(s2>s1){
            int c=nhelper(l1,l2.next,s1,s2-1);
            int v=l2.val+c;
            ListNode n=new ListNode(v%10);
            n.next=nhead;
            nhead=n;
            c=v/10;
            return c;
            
        }
        else{
            if(l1.next==null && l2.next==null){
                int v=l1.val+l2.val;
                 nhead=new ListNode(v%10);
                int c=v/10;
                return c;
            }
            int c=nhelper(l1.next,l2.next,s1-1,s2-1);
            int v=l1.val+l2.val+c;
            ListNode n=new ListNode(v%10);
            n.next=nhead;
            nhead=n;
            c=v/10;
            return c;
        }
    }
    public int size(ListNode l1){
        int s=0;
        while(l1!=null){
            s++;
            l1=l1.next;
        }
        return s;
    }
    // public int helper(ListNode l1, ListNode l2){
    //     if(l1.next==null && l2.next==null){
    //         int v=l1.val+l2.val;
    //         ListNode nhead=new ListNode(v%10);
    //         int c=v/10;
    //         return c;
    //     }
    //     else{
    //         int c=helper(l1.next,l2.next);
    //         int v=l1.val+l2.val+c;
    //         ListNode n=new ListNode(v%10);
    //         n.next=nhead;
    //         nhead=n;
    //         c=v/10;
    //         return c;
    //     }
    // }
}