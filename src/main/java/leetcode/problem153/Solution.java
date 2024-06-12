package leetcode.problem153;

public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if(nums[left] < nums[right]) return nums[left];
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[left] < nums[right]){
                right = mid - 1;
            }
            else{
                if(nums[mid] > nums[right]) left = mid + 1;
                else right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().findMin(new int[]{2,1}));
        System.out.println(new Solution().findMin(new int[]{3,1,2}));
        System.out.println(new Solution().findMin(new int[]{4,3,1,2}));
        System.out.println(new Solution().findMin(new int[]{3,4,5,1,2}));
        System.out.println(new Solution().findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(new Solution().findMin(new int[]{11,13,15,17}));
    }
}
