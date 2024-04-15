package leetcode.problem206;

import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 */
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
    public ListNode reverseList1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        if (stack.isEmpty()) return null;
        ListNode res = stack.pop();
        curr = res;
        while(!stack.isEmpty()){
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null;
        return res;
    }
    public ListNode reverseList(ListNode head){
        if (head == null) return null;
        ListNode cur = head, next = cur.next, front = null;
        while(cur != null){
            next = cur.next;
            cur.next = front;
            front = cur;
            cur = next;
        }
        return front;
    }
}
