package leetcode.problem53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int former_min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            former_min = Math.min(former_min, sum);
            sum += nums[i];
            res = Math.max(res, sum - former_min);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(s.maxSubArray(new int[]{1}));
        System.out.println(s.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
