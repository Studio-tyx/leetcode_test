package leetcode.problem739;

import java.util.*;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            res[i] = 0;
            if (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) res[i] = stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))); //[1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70}))); //[1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{30, 60, 90})));
    }
}
