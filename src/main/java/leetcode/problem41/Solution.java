package leetcode.problem41;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= 0) nums[i] = nums.length + 1;
        }
        for (int i = 0; i < nums.length; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        int res = nums.length + 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                res = i + 1;
                break;
            }
        }
        return res;
    }
    public int firstMissingPositive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long max = Integer.MIN_VALUE;
        for (int n : nums){
            set.add(n);
            max = Math.max(max, n);
        }
        int res = 1;
        for (; res <= max + 1; res++){
            if (!set.contains(res)){
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[]{1,1}));
        System.out.println(s.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(s.firstMissingPositive(new int[]{3,4,-1,1,9,-5}));
        System.out.println(s.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(s.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(s.firstMissingPositive(new int[]{1,2,3,10,2147483647,9}));

    }
}
