package leetcode.problem24;
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
    public ListNode swapPairs(ListNode head) {
        ListNode tmp_head = new ListNode(-1, head);
        ListNode cur = tmp_head;
        if(head == null) return head;
        do{
            ListNode next1 = cur.next;
            ListNode next2 = cur.next.next;
            if (next2 != null) {
                next1.next = next2.next;
                next2.next = next1;
                cur.next = next2;
                cur = next1;
            }
        }while (cur.next != null && cur.next.next != null);
        return tmp_head.next;
    }
    public static void main(String[] args) {
//        [1,2,4], l2 = [1,3,4]
        ListNode l1 = new ListNode(4);
        l1 = new ListNode(3, l1);
        l1 = new ListNode(2, l1);
        l1 = new ListNode(1, l1);
        System.out.println(new Solution().swapPairs(l1));
    }
}