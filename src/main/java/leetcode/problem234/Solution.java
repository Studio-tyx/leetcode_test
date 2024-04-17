package leetcode.problem234;

import java.util.ArrayList;
import java.util.Stack;

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
    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur);
            cur = cur.next;
        }
        int left = 0, right = list.size() - 1;
        while (left <= right){
            if (list.get(left).val != list.get(right).val) return false;
            left ++;
            right --;
        }
        return true;
    }
}

