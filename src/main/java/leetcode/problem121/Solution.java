package problem121;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] back_max = new int[n];
        back_max[n - 1] = prices[n - 1];
        int max_value = 0;
        for (int i = n - 2; i >= 0; i--){
            back_max[i] = Math.max(prices[i], back_max[i + 1]);
            int delta = back_max[i + 1] - prices[i];
            if (delta >= max_value){
                max_value = delta;
            }
        }
        return max_value;
    }
}
