package leetcode.problem35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left+right) / 2;
        while (left != right) {
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid+1;
                mid = (left+right) / 2;
            }
            else{
                right = mid;
                mid = (left + right) / 2;
            }
        }
        if (nums[left] < target) return left+1;
        else return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 7));
    }
}

