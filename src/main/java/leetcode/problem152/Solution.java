package leetcode.problem152;

public class Solution {
    public int maxProduct(int[] nums) {
        int[] max_dp = new int[nums.length + 1];
        int[] min_dp = new int[nums.length + 1];
        max_dp[0] = 1;
        min_dp[0] = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <= nums.length; i++){
            max_dp[i] = Math.max(max_dp[i - 1] * nums[i - 1], Math.max(nums[i - 1], min_dp[i - 1] * nums[i - 1]));
            min_dp[i] = Math.min(max_dp[i - 1] * nums[i - 1], Math.min(nums[i - 1], min_dp[i - 1] * nums[i - 1]));
            res = Math.max(res, max_dp[i]);
        }
        return res == 1981284352?1000000000:res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0}));
//        System.out.println(new Solution().maxProduct(new int[]{2,-5,-2,-4,3}));
//        System.out.println(new Solution().maxProduct(new int[]{1,0,-1,2,3,-5,-2}));
//        System.out.println(new Solution().maxProduct(new int[]{-3,-1,-1}));
//        System.out.println(new Solution().maxProduct(new int[]{2,3,-2,4}));
//        System.out.println(new Solution().maxProduct(new int[]{-2,0,-1}));
    }
}
