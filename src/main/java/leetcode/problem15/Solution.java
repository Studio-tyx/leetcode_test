package leetcode.problem15;
import java.util.*;
public class Solution {
    public static List<List<Integer>> find_i_j(int[]nums, int start, int end, int sum){
        List<List<Integer>> res = new ArrayList<>();
        int former = Integer.MIN_VALUE;
        while (start < end){
            if (nums[start] + nums[end] < sum){
                start ++;
            }
            else if (nums[start] + nums[end] == sum && former != nums[start]){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[start]);
                tmp.add(nums[end]);
                res.add(tmp);
                former = nums[start];
                start ++;
                end --;
            }
            else {
                end --;
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int now = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (now != nums[i]) {
                List<List<Integer>> tmp = find_i_j(nums, i + 1, nums.length - 1, -nums[i]);
                if (tmp.size() != 0) {
                    for (List<Integer> t : tmp) {
                        t.add(0, nums[i]);
                        res.add(t);
                    }
                }
            }
            now = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(s.threeSum(new int[]{0,1,1}));
        System.out.println(s.threeSum(new int[]{-2,0,0,2,2}));
    }
}
