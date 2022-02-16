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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode oh=null;
        ListNode ot=null;
        ListNode th=null;
        ListNode tt=null;
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        cur=head;
        while(cur!=null && len>=k){
            int tempk=k;
            while(tempk-->0 && cur!=null){
                ListNode temp=cur;
                cur=cur.next;
                temp.next=null;
                if(th==null){
                    th=tt=temp;
                }
                else{
                    temp.next=th;
                    th=temp;
                }
            }
            if(oh==null){
                oh=th;
                ot=tt;
            }
            else{
                ot.next=th;
                ot=tt;
            }
            len-=k;
            th=null;
            tt=null;
        }
        ot.next=cur;
        return oh;
        
    }
}