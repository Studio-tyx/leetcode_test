package leetcode.problem763;
import java.util.*;
public class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> idx_map = new HashMap<>();
        int[][] range = new int[s.length()][2];
        int tmp_idx = 0;
        for(int i = 0; i < s.length(); i++){
            int idx = tmp_idx;
            if(idx_map.containsKey(s.charAt(i))){
                idx = idx_map.get(s.charAt(i));
                range[idx][1] = i;
            }
            else{
                idx_map.put(s.charAt(i), idx);
                range[idx][0] = i;
                range[idx][1] = i;
                tmp_idx ++;
            }
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                else return o1[0] - o2[0];
            }
        };
        Arrays.sort(range, 0, idx_map.size(), comparator);
        List<Integer> res = new ArrayList<>();
        int cur_start = 0, cur_end = 0;
        for(int i = 0; i < idx_map.size(); i++){
            if(range[i][0] <= cur_end){
                cur_end = Math.max(cur_end, range[i][1]);
            }
            else{
                res.add(cur_end - cur_start + 1);
                cur_start = range[i][0];
                cur_end = range[i][1];
            }
        }
        res.add(cur_end - cur_start + 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("caedbdedda"));
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(new Solution().partitionLabels("eccbbbbdec"));
    }
}
