package leetcode.problem3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = Integer.MIN_VALUE;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }
            else{
                res = Math.max(res, i - start);
                start = Math.max(map.get(s.charAt(i)) + 1, start);
                map.replace(s.charAt(i), i);
            }
        }
        res = Math.max(res, s.length() - start);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
        System.out.println(s.lengthOfLongestSubstring("aab"));
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("abba"));
    }
}
