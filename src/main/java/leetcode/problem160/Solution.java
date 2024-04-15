package leetcode.problem160;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        ListNode headA_curr = headA;
        ListNode headB_curr = headB;
        while (headA_curr != null){
            headA_curr.val = - headA_curr.val;
            headA_curr = headA_curr.next;
        }
        while (headB_curr != null){
            if (headB_curr.val < 0){
                res = headB_curr;
//                res.val = - res.val;
                break;
            }
            headB_curr = headB_curr.next;
        }
        headA_curr = headA;
        while (headA_curr != null){
            headA_curr.val = - headA_curr.val;
            headA_curr = headA_curr.next;
        }
        return res;
    }
}
