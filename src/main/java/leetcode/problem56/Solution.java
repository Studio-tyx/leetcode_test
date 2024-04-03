package leetcode.problem56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return null;
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        ArrayList<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, comparator);
        int[] former = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if (intervals[i][0] > former[1]){
                merged.add(former);
                former = intervals[i];
            }
            else{
                former[1] = Math.max(former[1], intervals[i][1]);
            }
        }
        merged.add(former);
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }
}
