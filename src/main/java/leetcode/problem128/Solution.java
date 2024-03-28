package leetcode.problem128;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashSet;
import java.util.Set;
import java.util.TooManyListenersException;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n:nums){
            s.add(n);
        }
        int res = 0;
        for (int n:s){
            if (!s.contains(n-1)){
                int temp = 1;
                while (s.contains(n+1)){
                    temp += 1;
                    n += 1;
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(s.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
