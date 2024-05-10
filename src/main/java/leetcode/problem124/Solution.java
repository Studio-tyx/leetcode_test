package leetcode.problem124;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public int res;
    public int max_dfs(TreeNode node){
        if(node == null) return 0;
        else{
            int left = max_dfs(node.left);
            int right = max_dfs(node.right);
            res = Math.max(res, (Math.max(left, 0)) + (Math.max(right, 0)) + node.val);
            return Math.max((Math.max(left, 0)), (Math.max(right, 0))) + node.val;
        }
    }
    public int maxPathSum(TreeNode root) {
        if (root!= null) res = root.val;
        max_dfs(root);
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maxPathSum(new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(new Solution().maxPathSum(new TreeNode(1, new TreeNode(-2), new TreeNode(3))));
    }
}
