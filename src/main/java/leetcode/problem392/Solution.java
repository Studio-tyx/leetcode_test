package problem392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int t_idx = 0;
        int s_idx = 0;
        int count = 0;
        while(s_idx < s.length()){
            while(t_idx < t.length()){
                if(t.charAt(t_idx) == s.charAt(s_idx)){
                    count ++;
                    t_idx++;
                    break;
                }
                t_idx ++;
            }
            if(t_idx == t.length()){
                break;
            }
            s_idx++;
        }
        if (count != s.length()) return false;
        else return true;
    }
}
