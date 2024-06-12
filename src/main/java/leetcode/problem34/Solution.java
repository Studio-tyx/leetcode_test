// 感觉无论如何都不能放弃最简单的方法，有的时候虽然可能不用贪心或者dp这种比较难的算法，单纯把思路理清楚就已经能过了
package leetcode.problem34;

import java.util.Arrays;

public class Solution {
//    public int trap(int[] height) {
//        int n = height.length;
//        int res = 0;
//        for(int i = 0; i < n; i++){
//            int left_max = height[i];
//            for (int left = i; left >=0; left--){
//                if (height[left] >= left_max) left_max = height[left];
//            }
//
//            int right_max = height[i];
//            for (int right = i; right < n; right++){
//                if (height[right] >= right_max) right_max = height[right];
//            }
//            res += Math.min(left_max, right_max) - height[i];
//        }
//        return res;
//    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        boolean find = false;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target){
                    find = true;
                    break;
                }
                else right = mid - 1;
            }
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if(!find) return new int[]{-1, -1};
        res[0] = mid;
        left = mid;
        right = nums.length - 1;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) break;
                else left = mid + 1;
            }
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        res[1] = mid;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{2, 2}, 2)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{}, 8)));
    }
}
