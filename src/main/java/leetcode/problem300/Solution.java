package leetcode.problem300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <= nums.length; i++){
            int tmp_max = 0;
            for(int j = 1; j <= i; j++){
                if(nums[j - 1] < nums[i - 1]) tmp_max = Math.max(dp[j], tmp_max);
            }
            dp[i] = tmp_max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new Solution().lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(new Solution().lengthOfLIS(new int[]{7,7,7,7,7}));
    }
}
