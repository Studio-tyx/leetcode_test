package leetcode.problem76;

import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        int len = Integer.MAX_VALUE;
        int start = 0;
        Map<Character, Integer> need = new HashMap<>(), count = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        int left = 0, right = 0, valid = 0;
        while (right != s.length()){
            char r = s.charAt(right);
            right ++;
            if (need.containsKey(r)){
                count.put(r, count.getOrDefault(r, 0) + 1);
                if (count.get(r).equals(need.get(r))) valid ++;
            }
            while (valid == need.size()){
                if (right - left < len){
                    len = right - left;
                    start = left;
                }
                char l = s.charAt(left);
                left ++;
                if (need.containsKey(l)){
                    if (count.get(l).equals(need.get(l)))   valid --;
                    count.replace(l, count.get(l) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE? "":s.substring(start, start + len);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANCA", "ABC"));
        System.out.println(s.minWindow("a", "a"));
        System.out.println(s.minWindow("a", "aa"));
    }
}
