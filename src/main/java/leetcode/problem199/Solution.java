package leetcode.problem199;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            res.add(queue.get(queue.size()-1).val);
            List<TreeNode> next = new ArrayList<>();
            for(TreeNode node: queue){
                if(node.left != null) next.add(node.left);
                if(node.right != null) next.add(node.right);
            }
            queue = next;
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, null, new TreeNode(5));
        TreeNode right= new TreeNode(3, null, new TreeNode(4));
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(Arrays.toString(new Solution().rightSideView(root).toArray()));
    }
}
