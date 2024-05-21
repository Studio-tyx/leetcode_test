package leetcode.problem78;

import java.util.*;

public class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public Set<String> set = new HashSet<>();
    public void set_space(List<Integer> nums, int count){
        if(count == 0) return;
        for(int i = 0; i < nums.size(); i++){
            List<Integer> next = new ArrayList<>(nums);
            next.remove(i);
            if(!set.contains(next.toString())) {
                res.add(next);
                set.add(next.toString());
            }
            set_space(next, count - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        for(int n:nums){
            tmp.add(n);
        }
        res.add(tmp);
        set.add(Arrays.toString(nums));
        set_space(tmp, nums.length);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1,2,3}));
    }
}
