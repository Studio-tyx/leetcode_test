package leetcode.problem560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length == 0) return 0;
        int[] sum = new int[n+1];
        sum[0] = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i ++){
            sum[i+1] = sum[i] + nums[i];
            if (map.containsKey(sum[i+1] - k)){
                res += map.get(sum[i+1] - k);
            }
            map.put(sum[i+1], map.getOrDefault(sum[i+1],0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraySum(new int[]{-1, -1, 1}, -1));
        System.out.println(s.subarraySum(new int[]{1,1,1}, 2));
        System.out.println(s.subarraySum(new int[]{1,2,3}, 3));
    }
}
