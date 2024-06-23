package leetcode.problem5;

public class Solution {
    public String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = s.substring(0, 1);
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
            dp[0][i] = true;
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = 1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                    if(i + 1 >= j - 1){
                        dp[i][j] = true;
                    }
                    if(dp[i][j] && j - i + 1 >= res.length()){
                        res = s.substring(i, j + 1);
                    }
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return res;
    }

    public String longestPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = s.substring(0, 1);
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
            for(int j = 1; j <= Math.min(i, n - 1 - i); j++){
                if(s.charAt(i + j) == s.charAt(i - j)){
                    dp[i][j] = dp[i][j - 1];
                    if(dp[i][j]){
                        if(2 * j + 1 > res.length()) res = s.substring(i - j, i + j + 1);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        dp = new boolean[n][n];
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][0] = true;
                if(2 > res.length()) res = s.substring(i, i + 2);
                for (int j = 1; j <= Math.min(i, n - i - 2); j++) {
                    if (s.charAt(i + j + 1) == s.charAt(i - j)) {
                        dp[i][j] = dp[i][j - 1];
                        if (dp[i][j]) {
                            if(2 * j + 2 > res.length()) res = s.substring(i - j, i + j + 2);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("ababad"));
        System.out.println(new Solution().longestPalindrome("caba"));
        System.out.println(new Solution().longestPalindrome("abb"));
        System.out.println(new Solution().longestPalindrome("abbbb"));
        System.out.println(new Solution().longestPalindrome("aacabdkacaa"));
        System.out.println(new Solution().longestPalindrome("a"));
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}
