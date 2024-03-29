package leetcode.problem42;

import javax.swing.*;
import java.util.Arrays;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++){
            left[i] = Math.max(height[i], left[i-1]);
        }
        right[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--){
            right[i] = Math.max(height[i], right[i+1]);
        }
        int res = 0;
        for (int i = 1; i < n-1; i++){
            res += Math.max(Math.min(left[i-1], right[i+1]) - height[i], 0);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(s.trap(new int[]{4,2,0,3,2,5}));
    }
}
