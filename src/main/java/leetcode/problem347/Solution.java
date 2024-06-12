package leetcode.problem347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        Map<Integer, Set<Integer>> sets = new HashMap<>();
        for(Integer key : count.keySet()){
            if(sets.containsKey(count.get(key))){
                Set<Integer> set = sets.get(count.get(key));
                set.add(key);
                sets.put(count.get(key), set);
            }
            else{
                Set<Integer> set = new HashSet<>();
                set.add(key);
                sets.put(count.get(key), set);
            }
        }
        queue.addAll(count.values());
        int[] res = new int[k];
        int idx = 0;
        while(idx < k){
            int count_value = queue.peek();
            Set<Integer> key = sets.get(count_value);
            for(Integer item : key){
                res[idx++] = item;
                queue.poll();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 10)));
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{-1, -1}, 1)));
    }
}
