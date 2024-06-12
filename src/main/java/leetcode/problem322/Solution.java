package leetcode.problem322;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            int tmp_count = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i)
                    tmp_count = Math.min(tmp_count, dp[i - coin]);
            }
            dp[i] = tmp_count == Integer.MAX_VALUE? Integer.MAX_VALUE : (tmp_count + 1);
        }
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{2}, 3));
        System.out.println(new Solution().coinChange(new int[]{5,2,1}, 13));
        System.out.println(new Solution().coinChange(new int[]{5,2,1}, 11));
    }
}
