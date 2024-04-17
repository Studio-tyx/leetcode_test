package leetcode.problem141;

import java.util.HashSet;
import java.util.Set;

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
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur != null){
            if (!set.isEmpty() && set.contains(cur)) return true;
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        if (head != null) fast = fast.next;
        else return false;
        boolean flag = false;
        while (fast != null){
            fast = fast.next;
            if (fast != null) fast = fast.next;
            if(fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
}
