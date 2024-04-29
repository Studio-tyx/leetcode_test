package leetcode.problem98;

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
    public boolean check_valid(TreeNode node, long min, long max){
        if(node == null) return true;
        else if(node.val >= max || node.val <= min) return false;
        return check_valid(node.left, min, node.val) && check_valid(node.right, node.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return check_valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode tmp1= new TreeNode(3);
        TreeNode tmp2= new TreeNode(6);
        TreeNode right= new TreeNode(4, tmp1, tmp2);
        TreeNode root = new TreeNode(5, left, right);
        System.out.println(new Solution().isValidBST(root));
    }
}
