package leetcode.problem39;

import java.util.*;

public class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> tmp;
    public Set<Integer> set = new HashSet<>();
    public int[] nums;
    public void traverse(int target){
        if(set.contains(target)){
            tmp.add(target);
            res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
        }
        for(int i = 0; i < nums.length; i++){
            int key = nums[i];
            if(key > target) break;
            int lower_bound = 0;
            if(!tmp.isEmpty()) lower_bound = Math.max(lower_bound, tmp.get(tmp.size()-1));
            if((key == target ||(2*key <= target))&& key >= lower_bound){
                tmp.add(key);
                traverse(target - key);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        nums = candidates;
        tmp = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++){
            if(candidates[i] <= target) set.add(candidates[i]);
        }
        traverse(target);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(new Solution().combinationSum(new int[]{2}, 1));
//        System.out.println(new Solution().combinationSum(new int[]{2,3,5}, 8));
    }
}
