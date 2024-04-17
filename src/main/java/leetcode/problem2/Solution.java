package leetcode.problem2;
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res_head = null;
        ListNode res_cur = res_head;
        ListNode left = l1, right = l2;
        int jin = 0;
        while(left != null || right != null || jin != 0){
            int l = 0, r = 0;
            if (left!=null){
                l = left.val;
                left=left.next;
            }
            if (right != null){
                r = right.val;
                right = right.next;
            }
            ListNode tmp = new ListNode((jin + l + r) % 10);
            jin = (jin + l + r) >= 10 ? 1: 0;
            if (res_cur==null){
                res_cur = tmp;
                res_head = res_cur;
            }
            else{
                res_cur.next = tmp;
                res_cur = res_cur.next;
            }
        }
        return res_head;
    }
    public static void main(String[] args) {
//        l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(3);
        l1 = new ListNode(4, l1);
        l1 = new ListNode(2, l1);
        ListNode l2 = new ListNode(4);
        l2 = new ListNode(6, l2);
        l2 = new ListNode(5, l2);
        System.out.println(new Solution().addTwoNumbers(l1, l2));
//        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(0);
//        l2 = new ListNode(5, l2);
//        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }
}
