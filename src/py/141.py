# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        s = set()
        res = False
        while head not in s and head.next != None:
            s.add(head)
            head = head.next
            if head in s:
                res = True
        return res
        