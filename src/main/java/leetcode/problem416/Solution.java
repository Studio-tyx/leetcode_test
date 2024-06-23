package leetcode.problem416;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int item: nums){
            sum += item;
        }
        boolean[][] dp = new boolean[sum + 1][nums.length + 1];
//        Arrays.fill(dp, false);
        Arrays.sort(nums);
        int target = sum / 2;
        if(sum % 2 == 1) return false;
        for(int i = 0; i < nums.length; i++){
            dp[0][i] = true;
        }
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= target; j++){
                if(j >= nums[i - 1]) dp[j][i] = dp[j - nums[i - 1]][i - 1] | dp[j][i - 1];
                else dp[j][i] = dp[j][i - 1];
            }
        }
        return dp[target][nums.length];
    }
    public boolean canPartition_hash(int[] nums) {
        int sum = 0;
        for(int item: nums){
            sum += item;
        }
        if(sum % 2 != 0) return false;
        Arrays.sort(nums);
        Set<Integer> current = new HashSet<>();
        boolean res = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > sum / 2) break;
            if(current.contains(sum / 2 - nums[i]) || nums[i] == sum / 2){
                res = true;
                break;
            }
            else{
                Set<Integer> next = new HashSet<>();
                if(!current.isEmpty()) {
                    for (Integer tmp : current) {
                        next.add(tmp + nums[i]);
                    }
                }
                current.add(nums[i]);
                current.addAll(next);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1,1}));
        System.out.println(new Solution().canPartition(new int[]{1,5,11,5}));
        System.out.println(new Solution().canPartition(new int[]{1,2,11,6}));
        System.out.println(new Solution().canPartition(new int[]{1,2,5,6}));
        System.out.println(new Solution().canPartition(new int[]{1,2,3,5}));
    }
}
