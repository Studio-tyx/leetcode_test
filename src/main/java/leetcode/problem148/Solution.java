package leetcode.problem148;
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
    public ListNode sortList(ListNode head) {
        int window = 1;
        int count_size = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            count_size ++;
        }
        ListNode pre = new ListNode(-1, head);
        ListNode res_head = pre;
        if (count_size == 0) return head;
        while(window < count_size){
            cur = res_head.next;
            pre = res_head;
            while(cur != null) {
                ListNode left = cur;
                for(int i = 1; i < window && cur != null; i++){
                    cur = cur.next;
                }
                ListNode right = null;
                if (cur != null){
                    right = cur.next;
                    cur.next = null;
                }
                cur = right;
                for(int i = 1; i < window && cur != null; i++){
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null){
                    next = cur.next;
                    cur.next = null;
                }
                ListNode merge_res = merge(left, right);
                pre.next = merge_res;
                while(pre.next != null){
                    pre = pre.next;
                }
                cur = next;

//                pre = cur;
//                cur = next_pre;
            }
            window *= 2;
        }
//        System.out.println("hey");
        return res_head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1 = new ListNode(2, l1);
        l1 = new ListNode(1, l1);
        l1 = new ListNode(5, l1);
        l1 = new ListNode(3, l1);
        System.out.println(new Solution().sortList(l1));
    }
}
