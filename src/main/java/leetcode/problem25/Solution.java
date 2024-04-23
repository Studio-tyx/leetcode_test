package leetcode.problem25;

class ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class Solution {
    public void reverseNodes(ListNode start, ListNode end){
        ListNode cur = start.next;
        ListNode cur_front = start;
        ListNode next = cur;
        while(cur != null && cur_front != end){
            next = next.next;
            cur.next = cur_front;
            cur_front = cur;
            cur = next;
        }
        System.out.println("break");
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode front = new ListNode(-1, head);
        ListNode cur = head;
        boolean flag = false;
        while (cur != null){
            count ++;
            if (count == k){
                ListNode next = cur.next;
                reverseNodes(front.next, cur);
                ListNode next_front = front.next;
                front.next.next = next;
                front.next = cur;
                if(!flag){
                    head = cur;
                    flag = true;
                }

                front = next_front;
                count = 0;
                cur = next_front;
            }
            cur = cur.next;
        }
        System.out.println("hey");
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2);
        ListNode l4 = new ListNode(0, l3);
        new Solution().reverseKGroup(l4, 3);
    }
}
