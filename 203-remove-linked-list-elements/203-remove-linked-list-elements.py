# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        cur=head
        pre=None
        while cur!=None:
            if cur.val==val:
                if pre==None:
                    head=head.next
                else:
                    pre.next=cur.next
                cur=cur.next
            else:
                pre=cur
                cur=cur.next
        return head
            
                    
        