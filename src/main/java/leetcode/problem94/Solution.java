package leetcode.problem94;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// * Definition for a binary tree node.
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.push(root);
        TreeNode cur = root.left;
        while(!stack.isEmpty() || cur != null){
            if (cur == null){
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                cur= tmp.right;
            }
            else {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root = new TreeNode(2, root,null);
        root = new TreeNode(1, null, root);
        System.out.println(new Solution().inorderTraversal(root));
    }
}
