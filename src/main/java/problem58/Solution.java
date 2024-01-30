package problem58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        boolean start = false;
        for(int i = s.length() - 1; i >= 0; i--){
            if (!start && s.charAt(i) != ' ') start = true;
            else if (start && s.charAt(i) == ' ')break;
            if (start) res ++;
        }
        return res;
    }
}
