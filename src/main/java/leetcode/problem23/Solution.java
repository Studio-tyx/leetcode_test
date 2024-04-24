package leetcode.problem23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode res = new ListNode(-1, null);
        ListNode res_cur = res, head1_cur = head1, head2_cur = head2;
        while(head1_cur != null && head2_cur != null){
            if(head1_cur.val <= head2_cur.val){
                res_cur.next = head1_cur;
                head1_cur = head1_cur.next;
                res_cur = res_cur.next;
            }
            else{
                res_cur.next = head2_cur;
                head2_cur = head2_cur.next;
                res_cur = res_cur.next;
            }
        }
        if (head1_cur != null){
            res_cur.next = head1_cur;
        }
        if (head2_cur != null){
            res_cur.next = head2_cur;
        }
        return res.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> array = new LinkedList<>(Arrays.asList(lists));
        while(array.size() > 1){
            ListNode left = array.poll();
            ListNode right = array.poll();
            ListNode res = merge(left, right);
            array.add(res);
        }
//        System.out.println("break");
        return array.poll();
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1 = new ListNode(2, l1);
        ListNode l2 = new ListNode(5);
        l2 = new ListNode(1, l2);
        ListNode l3 = new ListNode(3);
        ListNode[] input = new ListNode[]{l1, l2, l3};
        System.out.println(new Solution().mergeKLists(input));
    }
}
