package problem274;


import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int res = 0;
        for(int i = 0; i < n; i++){
            int count = Integer.min((n-i), citations[i]);
            if (n - i <= citations[i]) {
                if (count >= res){
                    res = count;
                }
            }
        }
        return res;
    }
}
