package leetcode.problem1;

import java.util.*;
import java.util.concurrent.TransferQueue;

public class Solution {
    public int[] twoSum1(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        };
        Arrays.sort(arr, comparator);
        int start = 0, end = nums.length-1;
        while(start!=end){
            if (arr[start][0] + arr[end][0] < target){
                start += 1;
            }
            else if (arr[start][0] + arr[end][0] == target) {
                return new int[]{arr[start][1], arr[end][1]};
            }
            else{
                end -= 1;
            }
        }
        return new int[]{0, 0};
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (m.containsKey(target - nums[i])) {
                return new int[]{m.get(target-nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return  new int[]{0,0};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.twoSum(new int[]{3,3}, 6);
        System.out.println(res[0]+","+res[1]);
        res = s.twoSum(new int[]{3,2,4}, 6);
        System.out.println(res[0]+","+res[1]);
        res = s.twoSum(new int[]{2,7,11,10}, 12);
        System.out.println(res[0]+","+res[1]);
//        System.out.println(s.twoSum(new int[]{2,7,11,15}, 18)[0]+", "+s.twoSum(new int[]{2,7,11,15}, 18)[1]);
    }
}

