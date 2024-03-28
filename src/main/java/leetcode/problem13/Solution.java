package problem13;

public class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int res = 0;
        int former = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int now;
            char ch = s.charAt(i);
            if (ch == 'I') now = 1;
            else if (ch == 'V') now = 5;
            else if (ch == 'X') now = 10;
            else if (ch == 'L') now = 50;
            else if (ch == 'C') now = 100;
            else if (ch == 'D') now = 500;
            else if (ch == 'M') now = 1000;
            else now = 0;
            if (now > former){
                res -= former * 2;
            }
            res += now;
            former = now;
        }
        return res;
    }
}