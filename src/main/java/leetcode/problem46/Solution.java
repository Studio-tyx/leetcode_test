package leetcode.problem46;

import java.security.Key;
import java.util.*;

public class Solution {
    public Set<String> compare_set = new HashSet<>();
    public List<List<Integer>> res = new ArrayList<>();
    public Map<Integer, Integer> count = new HashMap<>();
    public void dfs(int[] current, int idx){
        if(idx <= current.length-1){
            Map<Integer, Integer> compare = new HashMap<>(count);
            for(int i = 0; i < idx; i ++){
                compare.put(current[i], compare.get(current[i])-1);
            }
            for(int key:compare.keySet()){
                if(compare.get(key)!= 0) {
                    current[idx] = key;
                    dfs(current, idx + 1);
                }
            }
        }
        else if(idx == current.length){
            if(!compare_set.contains(Arrays.toString(current))){
                List<Integer> tmp = new ArrayList<>();
                for(int x: current){
                    tmp.add(x);
                }
                res.add(tmp);
                compare_set.add(Arrays.toString(current));
            }
            return;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int[] current = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        dfs(current, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1,2,3}));
//        System.out.println(new Solution().permute(new int[]{1,2}));
    }
}
