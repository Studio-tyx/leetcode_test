package problem151;

public class Solution {
    public String reverseWords(String s) {
        int start = s.length() - 1;
        boolean is_start = false;
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--){
            if (!is_start && s.charAt(i) != ' '){
                start = i;
                is_start = true;
            }
            if (i >= 1){
                if (s.charAt(i) != ' ' && s.charAt(i - 1) == ' '){
                    res.append(" ").append(s, i, start+1);
                    is_start = false;
                }
            }
            else {
                if (s.charAt(i) != ' '){
                    res.append(" ").append(s, i, start+1);
                    is_start = false;
                }
            }
        }
        return res.substring(1);
    }
}
