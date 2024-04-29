package leetcode.problem108;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode BST(int[] nums, int start, int end){
        if (end != start + 1){
            int mid = (start + end) / 2;
            TreeNode left = null, right = null;
            if(start < mid) left = BST(nums, start, mid);
            if(mid + 1 < end) right = BST(nums, mid + 1, end);
            return new TreeNode(nums[mid], left, right);
        }
        else{
            return new TreeNode(nums[start]);
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return BST(nums,0, n);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
