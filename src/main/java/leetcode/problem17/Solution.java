package leetcode.problem17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] numString = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> res = new ArrayList<>();
    public StringBuilder tmp ;
    public void dfs1(String cur, String digits){
        if(cur.length() == digits.length()){
            res.add(cur);
        }
        else{
            int length = cur.length();
            int idx = digits.charAt(length) - '0' - 1;
            for(int i = 0; i < numString[idx].length(); i++){
                dfs1(cur+numString[idx].charAt(i), digits);
            }
        }
    }

    public void dfs(int idx, String digits){
        if(idx == digits.length()){
            res.add(String.valueOf(tmp));
        }
        else{
            int ii = digits.charAt(idx) - '0'-1;
            for(int i = 0; i < numString[ii].length(); i++){
                tmp.append(numString[ii].charAt(i));
                dfs(idx + 1, digits);
                tmp.deleteCharAt(idx);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        tmp = new StringBuilder();
        dfs(0, digits);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
