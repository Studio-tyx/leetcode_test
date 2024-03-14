# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def mergeTwoLists(self, list1, list2):
        l1 = list1
        l2 = list2
        if l1 == None and l2 == None: return None
        res = ListNode()
        res_now = res
        res_now.val = 0
        while l1 != None or l2 != None:
            if res_now.val != 0:
                tmp = ListNode()
                res_now.next = tmp
                res_now = res_now.next
            if l1 == None and l2 != None:
                res_now.val = l2.val
                l2 = l2.next
            elif l1 != None and l2 == None:
                res_now.val = l1.val
                l1 = l1.next
            elif l1.val < l2.val:
                res_now.val = l1.val
                l1 = l1.next
            elif l1.val >= l2.val:
                res_now.val = l2.val
                l2 = l2.next
        # tmp = res 
        # while tmp != None:
        #     print(tmp.val, end= ',')
        #     tmp = tmp.next
        return res
    
if __name__ == "__main__":
    l1 = ListNode()
    l2 = ListNode()
    l1_now = l1
    l2_now = l2
    l1_now.val, l2_now.val = 2, 9
    l1_now.next = ListNode()
    l1_now = l1_now.next
    l1_now.val= 5
    l1_now.next = ListNode()
    l1_now = l1_now.next
    l1_now.val= 7
    s = Solution()
    print(s.mergeTwoLists(l1, l2))