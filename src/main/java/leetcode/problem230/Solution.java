package leetcode.problem230;

import java.util.ArrayList;
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int res = root.val;
        while(!stack.isEmpty() ||cur != null){
            if(cur == null){
                TreeNode node = stack.pop();
                res = node.val;
                k --;
                if(k == 0) break;
                cur = node.right;
            }
            else{
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode tmp1= new TreeNode(2, new TreeNode(1), null);
        TreeNode left = new TreeNode(3, tmp1, new TreeNode(4));
        TreeNode root = new TreeNode(5, left, new TreeNode(6));
        System.out.println(new Solution().kthSmallest(root, 3));
    }
}
