package leetcode.problem567;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(), count = new HashMap<>();
        for (int i = 0; i<s1.length(); i++){
            if (need.containsKey(s1.charAt(i))) need.replace(s1.charAt(i), need.get(s1.charAt(i))+1);
            else{
                need.put(s1.charAt(i), 1);
                count.put(s1.charAt(i), 0);
            }
        }
        boolean res = false;
        int left = 0, right = 0;
        int valid = 0;
        while (right != s2.length()){
            char r = s2.charAt(right);
            right ++;
            if (need.containsKey(r)){
                count.replace(r, count.get(r) + 1);
                if (count.get(r).equals(need.get(r))){
                    valid ++;
                }
            }
            while (right - left >= s1.length()){
                if (valid == need.size()){
                    res = true;
                    return res;
                }
                char l = s2.charAt(left);
                left ++;
                if (need.containsKey(l)){
                    if (count.get(l).equals(need.get(l))){
                        valid --;
                    }
                    count.replace(l, count.get(l) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkInclusion("abc", "dcba"));
        System.out.println(s.checkInclusion("ab", "eidbaooo"));
        System.out.println(s.checkInclusion("ab", "eidboaoo"));
    }
}
