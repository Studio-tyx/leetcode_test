package leetcode.problem62;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= n; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            dp[i][0] = 1;
            for(int j = 1; j < n; j++){
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 3));
        System.out.println(new Solution().uniquePaths(3, 7));
        System.out.println(new Solution().uniquePaths(3, 2));
    }
}
