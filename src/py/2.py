# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        node1 = l1
        node2 = l2
        res = ListNode()
        res_now = res
        add = 0
        while node1 != None or node2 != None or add != 0:
            left = 0
            right = 0
            if node1 != None:
                left = node1.val
                node1 = node1.next
            if node2 != None:
                right = node2.val
                node2 = node2.next
            res_now.val = (left + right + add) % 10
            add = (left + right + add) // 10
            if node1 != None or node2 != None or add != 0:
                tmp = ListNode()
                res_now.next = tmp
                res_now = tmp
        tmp = res 
        while tmp != None:
            print(tmp.val, end= ',')
            tmp = tmp.next
        return res


if __name__ == "__main__":
    l1 = ListNode()
    l2 = ListNode()
    l1_now = l1
    l2_now = l2
    l1_now.val, l2_now.val = 9, 9
    l1_now.next = ListNode()
    l2_now.next = ListNode()
    l1_now = l1_now.next
    l2_now = l2_now.next
    l1_now.val= 9
    l1_now.next = ListNode()
    l1_now = l1_now.next
    l1_now.val= 9
    # l1_now.next = ListNode()
    # l2_now.next = ListNode()
    # l1_now = l1_now.next
    # l2_now = l2_now.next
    s = Solution()
    print(s.addTwoNumbers(l1, l2))