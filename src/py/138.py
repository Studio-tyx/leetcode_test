"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head):
        if head == None: return None
        h = {}
        current = head
        while current != None:
            tmp = Node(current.val)
            h[current] = tmp
            current = current.next
        current = head
        while current != None:
            if current.next != None: h[current].next = h[current.next]
            if current.random != None: h[current].random = h[current.random]
            current = current.next
        return h[head]
    


