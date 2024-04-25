package leetcode.problem226;
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
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            invertTree(root.left);
            invertTree(root.right);
        }
        System.out.println("break");
        return root;
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(3);
        TreeNode right= new TreeNode(2);
        TreeNode root = new TreeNode(1, left, right);
        new Solution().invertTree(root);
    }
}
