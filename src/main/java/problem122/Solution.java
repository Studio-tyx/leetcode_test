package problem122;

import java.util.HashMap;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i ++){
            int max_i = dp[i - 1];
            for (int j = i; j>=0; j--){
                if (prices[i] > prices[j]){
                    if (dp[j] + prices[i] - prices[j] >= max_i){
                        max_i = dp[j] + prices[i] - prices[j];
                    }
                }
            }
            dp[i] = max_i;
        }
        return dp[n - 1];
    }
}
