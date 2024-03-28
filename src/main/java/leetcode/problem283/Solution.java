package leetcode.problem283;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = 0;
        while (end != nums.length){
            if (nums[end] != 0){
                nums[start] = nums[end];
                start ++;
            }
            end ++;
        }
        while (start != nums.length){
            nums[start] = 0;
            start ++;
        }
//        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.moveZeroes(new int[]{0,1,0,3,12});
        s.moveZeroes(new int[]{0});
    }
}
