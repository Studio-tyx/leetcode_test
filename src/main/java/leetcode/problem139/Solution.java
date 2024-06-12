package leetcode.problem139;

import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(String str : wordDict){
                if(str.length() <= i){
                    int start = i - str.length();
                    if(dp[start] && s.substring(start, i).equals(str)){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode", new ArrayList<>(Arrays.asList(new String[]{"leet", "code"}))));
        System.out.println(new Solution().wordBreak("applepenapple", new ArrayList<>(Arrays.asList(new String[]{"apple", "pen"}))));
        System.out.println(new Solution().wordBreak("catsandog", new ArrayList<>(Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"}))));
    }
}
