package leetcode.problem131;

import java.util.*;

public class Solution {
    public boolean is_reverse(String s){
        if(s.length() == 1) return true;
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
    public List<List<String>> res;

    public void trace_back(String s, int start, int end, List<String> tmp_solution){
        if(end >= s.length()){
            if(is_reverse(s.substring(start))){
                tmp_solution.add(s.substring(start, end));
                res.add(new ArrayList<>(tmp_solution));
            }
            return;
        }
        if(is_reverse(s.substring(start, end))){
            tmp_solution.add(s.substring(start, end));
            trace_back(s, end, end + 1, new ArrayList<>(tmp_solution));
            tmp_solution.remove(tmp_solution.size() - 1);
            trace_back(s, start, end + 1, new ArrayList<>(tmp_solution));
        }
        else{
            trace_back(s, start, end + 1, new ArrayList<>(tmp_solution));
        }
    }
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        trace_back(s, 0, 1, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
        System.out.println(new Solution().partition("aaaa"));
        System.out.println(new Solution().partition("ababa"));
        System.out.println(new Solution().partition("aabbaa"));
        System.out.println(new Solution().partition("a"));
    }
}
