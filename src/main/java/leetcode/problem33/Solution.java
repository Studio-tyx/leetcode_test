package leetcode.problem33;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] == target) return left;
            if(nums[right] == target) return right;
            if(nums[left] > nums[right]){
                if(nums[mid] > nums[left]){
                    if(target < nums[mid] && target > nums[left]) right = mid - 1;
                    else left = mid + 1;
                }
                else{
                    if(target < nums[right] && target > nums[mid]) left = mid + 1;
                    else right = mid - 1;
                }
            }
            else{
                if(nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{5,1,2,3,4}, 1));
        System.out.println(new Solution().search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(new Solution().search(new int[]{4,5,6,7,8,1,2,3}, 8));
        System.out.println(new Solution().search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(new Solution().search(new int[]{1}, 0));
    }
}
