package leetcode.problem215;

public class Solution {
    public int[] refresh(int[] a, int start, int length){
        if(start >= length) return a;
        int left = start * 2 + 1, right = start * 2 + 2;
        int largest = start;
        if(left < length && a[largest] <= a[left]) largest = left;
        if(right < length && a[largest] <= a[right]) largest = right;
        if(start != largest) {
            int tmp = a[start];
            a[start] = a[largest];
            a[largest] = tmp;
            a = refresh(a, largest, length);
        }
        return a;
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for(int i = n - 1; i >= 0; i--){
            nums = refresh(nums, i, n);
        }
        int res = 0;
        for(int i = 0; i < k; i++){
            res = nums[0];
            int length = n - i - 1;
            nums[0] = nums[length];
            nums = refresh(nums, 0, length);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
