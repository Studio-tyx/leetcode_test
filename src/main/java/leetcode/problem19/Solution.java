package leetcode.problem19;
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fake_head = new ListNode(-1, head);
        ListNode fast = fake_head, slow = head;
        for(int i = 0; i < n; i++){
            slow = slow.next;
        }
        while (slow != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = fast.next.next;
        return fake_head.next;
    }
}
