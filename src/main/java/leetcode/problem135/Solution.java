// 还是没顶住，想了一下午没想出啥，用了官方题解。
// 感觉还是要仔细梳理题目的条件。等于是很弱智地找到了满足所有规则的解。
package problem135;

public class Solution {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++){
            if (ratings[i-1]<ratings[i])    left[i] = left[i-1] + 1;
            else left[i] = 1;
        }
        for (int i = n-2; i >= 0; i--){
            if (ratings[i+1]<ratings[i])    right[i] = right[i + 1] + 1;
            else right[i] = 1;
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}

