package leetcode.problem279;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int sqt = (int) Math.sqrt(i);
            int min_count = dp[i - 1];
            for(int j = 2; j <= sqt; j++){
                min_count = Math.min(dp[i - j * j], min_count);
            }
            dp[i] = min_count + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(13));
        System.out.println(new Solution().numSquares(12));
    }
}
