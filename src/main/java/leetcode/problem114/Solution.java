package leetcode.problem114;

import java.util.Arrays;
import java.util.Stack;

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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, front = new TreeNode(-1);
        if(root == null) return;
        while(!stack.isEmpty() || cur != null){
            if(cur == null){
                TreeNode node = stack.pop();
                front.right = node;
                front.left = null;
                cur = node;
            }
            else{
                if(cur.right != null) stack.push(cur.right);
                front.right = cur;
                front.left = null;
                front = cur;
                cur = cur.left;
            }
        }
        System.out.println("break");
    }
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
//        TreeNode right= new TreeNode(5, null, new TreeNode(6));
//        TreeNode root = new TreeNode(1, left, right);
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(4, new TreeNode(3), null)));
        new Solution().flatten(root);
    }
}
