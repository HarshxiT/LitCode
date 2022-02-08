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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=null;
        for(ListNode n:lists){
            ans=merge(ans,n);
        }
        return ans;
        
    }
    public ListNode merge(ListNode a,ListNode b){
        ListNode ans=new ListNode(-1);
        ListNode head=ans;
        while(a!=null && b!=null){
            if(a.val<b.val){
                ans.next=a;
                a=a.next;
            }
            else{
                ans.next=b;
                b=b.next;
            }
            ans=ans.next;
        }
        if(a!=null)ans.next=a;
        if(b!=null)ans.next=b;
        return head.next;
    }
}