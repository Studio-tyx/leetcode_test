package leetcode.problem102;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while(!level.isEmpty()){
            List<TreeNode> next = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            for(TreeNode node : level){
                tmp.add(node.val);
                if(node.left != null) next.add(node.left);
                if(node.right != null) next.add(node.right);
            }
            level = next;
            res.add(tmp);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(3);
        TreeNode tmp1= new TreeNode(4);
        TreeNode tmp2= new TreeNode(5);
        TreeNode right= new TreeNode(2, tmp1, tmp2);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(new Solution().levelOrder(root));
    }
}
