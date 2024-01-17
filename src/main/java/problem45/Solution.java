package problem45;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] max_cover = new int[n];
        for (int i = 0; i < n; i++){
            max_cover[i] = i + nums[i];
        }
        if (n == 1) return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i ++){
            int min_step = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--){
                if (max_cover[j] >= i){
                    int j_step = dp[j] + 1;
                    if (j_step <= min_step){
                        min_step = j_step;
                    }
                }
            }
            dp[i] = min_step;
        }
        return dp[n - 1];
    }
}
