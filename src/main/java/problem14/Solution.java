package problem14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int max_len = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++){
            if (strs[i].length() <= max_len) max_len = strs[i].length();
        }
        for (int i = 0; i <max_len; i++){
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++){
                if (strs[j].charAt(i) != ch) return res.toString();
            }
            res.append(ch);
        }
        return res.toString();
    }
}
