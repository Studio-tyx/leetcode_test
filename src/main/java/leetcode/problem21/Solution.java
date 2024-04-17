package leetcode.problem21;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode left = list1;
        ListNode right = list2;
        ListNode res = null;
        ListNode res_cur = null;
        while(left != null || right != null){
            if (right == null || (left != null && left.val < right.val)){
                if (res_cur == null){
                    res_cur = left;
                    res = res_cur;
                }
                else{
                    res_cur.next = new ListNode(left.val);
                    res_cur = res_cur.next;
                }
                left = left.next;
            }
            else {
                if (res_cur == null){
                    res_cur = right;
                    res = res_cur;
                }
                else{
                    res_cur.next = new ListNode(right.val);
                    res_cur = res_cur.next;
                }
                right = right.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        [1,2,4], l2 = [1,3,4]
        ListNode l1 = new ListNode(4);
        l1 = new ListNode(2, l1);
        l1 = new ListNode(1, l1);
        ListNode l2 = new ListNode(4);
        l2 = new ListNode(3, l2);
        l2 = new ListNode(1, l2);
        System.out.println(new Solution().mergeTwoLists(l1, l2));
    }
}
