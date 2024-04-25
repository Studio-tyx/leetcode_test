package leetcode.problem104;

import java.util.ArrayList;
import java.util.List;

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
    public int maxDepth(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<TreeNode> next = new ArrayList<>();
            for(TreeNode node:queue){
                if(node.left != null) next.add(node.left);
                if(node.right != null) next.add(node.right);
            }
            queue = next;
            res ++;
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root = new TreeNode(2, root,null);
        root = new TreeNode(1, null, root);
        System.out.println(new Solution().maxDepth(root));
    }
}
