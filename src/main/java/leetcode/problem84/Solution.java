package leetcode.problem84;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> shun = new LinkedList<>();
        Deque<Integer> ni = new LinkedList<>();
        int[] l = new int[heights.length];
        int[] r = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            while(!shun.isEmpty() && heights[shun.peek()] >= heights[i]){
                shun.pop();
            }
            l[i] = shun.isEmpty()? -1 : shun.peek();
            shun.push(i);
        }
        for(int i = heights.length - 1; i >= 0; i--){
            while(!ni.isEmpty() && heights[ni.peek()] >= heights[i]){
                ni.pop();
            }
            r[i] = ni.isEmpty()? heights.length : ni.peek();
            ni.push(i);
        }
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            res = Math.max(res, heights[i] * Math.max(0, (r[i] - l[i] - 1)));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(new Solution().largestRectangleArea(new int[]{6,7,5,2,4,5,9,3}));
        System.out.println(new Solution().largestRectangleArea(new int[]{2,4}));
    }
}
