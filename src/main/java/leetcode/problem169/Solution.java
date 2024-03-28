package problem169;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i:nums){
            if (count.containsKey(i)){
                count.replace(i, count.get(i) + 1);
            }
            else {
                count.put(i, 1);
            }
        }
        int max = 0;
        int max_num = 0;
        for (Integer i: count.keySet()){
            if (max < count.get(i)){
                max = count.get(i);
                max_num = i;
            }
//            System.out.print(i+":"+count.get(i)+",");
        }
//        System.out.println();
        return max_num;
    }
}