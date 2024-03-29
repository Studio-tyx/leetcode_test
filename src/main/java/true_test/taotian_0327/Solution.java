package true_test.taotian_0327;
// 趁在这里多写一点吧，第一题是找数组的最小元素，返回最大元素这样
// 是可以用最小堆的，PriorityQueue，很适合这个

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public void score(){
        int[] score = new int[]{3,2,5,12,43,5};
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < score.length; i++){
            q.add(score[i]);
            res = Math.max(res, score[i]);
        }
        System.out.println(Arrays.toString(q.toArray()));
        for (int i = 0; i < 6; i++){
            int new_val = q.poll() + 100;
            res = Math.max(res, new_val);
            q.add(new_val);
            System.out.println(Arrays.toString(q.toArray()));
            System.out.println("max:"+res);
        }
        System.out.println(Arrays.toString(q.toArray()));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.score();
    }
}
