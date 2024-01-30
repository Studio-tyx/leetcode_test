package problem12;

import java.util.Arrays;

public class Solution {
    public String intToRoman(int num) {
        String[] one = new String[]{"I", "X", "C", "M"};
        String[] five = new String[]{"V", "L", "D"};
        int[] wei = new int[4];
        wei[0] = num % 10;
        wei[1] = (num / 10) % 10;
        wei[2] = (num / 100) % 10;
        wei[3] = num / 1000;
        System.out.println(Arrays.toString(wei));
        String res = "";
        for (int i = 3; i >= 0; i--){
            if(wei[i] == 0) {
            }
            else if (wei[i] == 4){
                res += one[i] + five[i];
            }
            else if (wei[i] == 9){
                res += one[i] + one[i+1];
            }
            else if (wei[i]<=3){
                for (int j = 0; j < wei[i]; j++) res += one[i];
            }
            else if (wei[i] <= 8){
                res += five[i];
                for (int j = 5; j < wei[i]; j++) res += one[i];
            }
        }
        return res;
    }
}
