package leetcode.problem543;

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
    int max_length = 0;
    public int cal_length(TreeNode node){
        if(node == null) return 0;
        else{
            int left_length = cal_length(node.left);
            int right_length = cal_length(node.right);
            max_length = Math.max(max_length, left_length+right_length);
            return Math.max(left_length, right_length) + 1;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        cal_length(root);
        return max_length;
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(3);
        TreeNode tmp1= new TreeNode(4);
        TreeNode tmp2= new TreeNode(5);
        TreeNode right= new TreeNode(2, tmp1, tmp2);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}
