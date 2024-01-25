// 感觉无论如何都不能放弃最简单的方法，有的时候虽然可能不用贪心或者dp这种比较难的算法，单纯把思路理清楚就已经能过了
package problem34;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            int left_max = height[i];
            for (int left = i; left >=0; left--){
                if (height[left] >= left_max) left_max = height[left];
            }

            int right_max = height[i];
            for (int right = i; right < n; right++){
                if (height[right] >= right_max) right_max = height[right];
            }
            res += Math.min(left_max, right_max) - height[i];
        }
        return res;
    }
}
