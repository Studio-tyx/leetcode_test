package leetcode.problem239;

import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res_len = nums.length - k + 1;
        int[] res = new int[res_len];
        Deque<Integer> deque = new LinkedList<>();
        int left = 0, right = k;
        for(int i = left; i < right; i++){
            while (!deque.isEmpty() && deque.getLast() < nums[i]){
                deque.pollLast();
            }
            deque.add(nums[i]);
        }
        res[left] = deque.getFirst();
        while (right != nums.length){
            while (!deque.isEmpty() && deque.getLast() < nums[right]){
                deque.pollLast();
            }
            deque.add(nums[right]);
            if (deque.getFirst() == nums[left]) deque.pollFirst();
            left ++;
            res[left] = deque.getFirst();
            right ++;
        }
        return res;
    }
    public int[] maxSlidingWindow_tle(int[] nums, int k) {
        int res_len = Math.max(nums.length - k + 1, k);
        int[] res = new int[res_len];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int left = 0, right = k;
        for (int i = left; i < right; i++){
            heap.add(nums[i]);
        }
        res[0] = heap.element();
        while (right != nums.length){
            heap.remove(nums[left]);
            heap.add(nums[right]);
            left ++;
            right ++;
            res[left] = heap.element();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1},1)));
    }
}
