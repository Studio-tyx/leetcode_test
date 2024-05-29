package leetcode.problem22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> res = new ArrayList<>();
    public void back_track(int left_n, int right_n, int sum, String str){
        if(left_n == sum && right_n == sum){
            res.add(str);
        }
        if(left_n >= right_n && left_n <= sum && right_n <= sum){
            back_track(left_n + 1, right_n, sum, str+"(");
            back_track(left_n, right_n + 1, sum, str+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        back_track(0,0 , n, "");
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}
