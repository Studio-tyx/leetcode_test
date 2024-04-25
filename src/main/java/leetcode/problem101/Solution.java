package leetcode.problem101;
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
    public boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        else{
            return check(left.left, right.right) && check(left.right, right.left);
        }
    }
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        return check(left,right);
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(3);
        TreeNode right= new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(new Solution().isSymmetric(root));
    }
}
