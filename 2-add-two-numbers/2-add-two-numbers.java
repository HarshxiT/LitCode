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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;
        ListNode nhead=new ListNode(-1);
        ListNode t=nhead;
        while(l1!=null && l2!=null){
            int temp=l1.val+l2.val+c;
            c=temp/10;
            ListNode n=new ListNode(temp%10);
            t.next=n;
            t=t.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int temp=l1.val+c;
            c=temp/10;
            ListNode n=new ListNode(temp%10);
            t.next=n;
            t=t.next;
            l1=l1.next;
        }
        while(l2!=null){
            int temp=l2.val+c;
            c=temp/10;
            ListNode n=new ListNode(temp%10);
            t.next=n;
            t=t.next;
            l2=l2.next;
        }
        if(c!=0){
            ListNode n=new ListNode(c);
            t.next=n;
        }
        return nhead.next;
    }
}