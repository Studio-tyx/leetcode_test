package leetcode.problem437;

import java.util.*;

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
    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        if (root== null) return count;
        Map<TreeNode, Map<Long, Long>> node2map = new HashMap<>();
        Map<TreeNode, Long> node2sum = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        Map<Long, Long> tmp = new HashMap<>();
        tmp.put((long)0, (long)1);
        tmp.put((long)root.val, tmp.getOrDefault((long)root.val, (long)0)+1);
        count += tmp.getOrDefault((long)(root.val - targetSum), (long)0);
        node2map.put(root, tmp);
        node2sum.put(root,(long)root.val);
        while(!list.isEmpty()){
            List<TreeNode> next = new ArrayList<>();
            for(TreeNode node : list){
//                Map<Integer, Integer> former = node2map.get(node);
                if(node.left != null){
                    next.add(node.left);
                    Map<Long, Long> value_count = new HashMap<>(node2map.get(node));
                    long sum_now = node2sum.get(node) + node.left.val;
                    value_count.put(sum_now, value_count.getOrDefault(sum_now, (long)0) + 1);
                    count += value_count.getOrDefault(sum_now - targetSum, (long)0);
                    node2map.put(node.left, value_count);
                    node2sum.put(node.left, sum_now);
                }
                if(node.right != null){
                    next.add(node.right);
                    Map<Long, Long> value_count = new HashMap<>(node2map.get(node));
                    long sum_now = node2sum.get(node) + node.right.val;
                    value_count.put(sum_now, value_count.getOrDefault(sum_now, (long)0) + 1);
                    count += value_count.getOrDefault(sum_now - targetSum, (long)0);
                    node2map.put(node.right, value_count);
                    node2sum.put(node.right, sum_now);
                }
            }
            list = next;
        }
        if (targetSum == 0) count -= node2sum.size();
        return count;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root = new TreeNode(0, new TreeNode(1), new TreeNode(1));
        System.out.println(new Solution().pathSum(root,1));
        root = new TreeNode(10,
                new TreeNode(5,
                    new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null,new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        System.out.println(new Solution().pathSum(root, 8));
        root = new TreeNode(5, new TreeNode(4, null, new TreeNode(11, new TreeNode(7), new TreeNode(2))),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(new Solution().pathSum(root, 22));
        root = new TreeNode(1, new TreeNode(2), new TreeNode(23));
        System.out.println(new Solution().pathSum(root, 0));
    }
}
