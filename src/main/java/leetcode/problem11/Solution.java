package leetcode.problem11;

import java.util.Arrays;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = Integer.MIN_VALUE;
        while(left != right){
            res = Math.max(res, Math.min(height[left], height[right]) * Math.abs(left - right));
            if (height[left] < height[right]){
                left ++;
            }
            else{
                right --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(s.maxArea(new int[]{1,1}));
        System.out.println(s.maxArea(new int[]{1,2,1}));
    }
}
