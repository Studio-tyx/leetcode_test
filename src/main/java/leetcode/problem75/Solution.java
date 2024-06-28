package leetcode.problem75;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int count_0 = 0, count_1 = 0, count_2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) count_0 ++;
            else if(nums[i] == 1) count_1 ++;
            else count_2 ++;
        }
        int start = 0;
        while(start != nums.length){
            while(count_0 != 0){
                nums[start] = 0;
                count_0 --;
                start ++;
            }
            while(count_1 != 0){
                nums[start] = 1;
                count_1 --;
                start ++;
            }
            while(count_2 != 0){
                nums[start] = 2;
                count_2 --;
                start ++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Solution().sortColors(new int[]{2,0,2,1,1,0});
    }
}
