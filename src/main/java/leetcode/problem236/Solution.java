package leetcode.problem236;

import com.sun.org.apache.xpath.internal.operations.Or;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<TreeNode> p_list = new ArrayList<>();
        List<TreeNode> q_list = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, root);
        while(!list.isEmpty()){
            List<TreeNode> next = new ArrayList<>();
            for(TreeNode node : list){
                if(node.left != null){
                    next.add(node.left);
                    parent.put(node.left, node);
                }
                if(node.right != null){
                    next.add(node.right);
                    parent.put(node.right, node);
                }
            }
            list = next;
        }
        TreeNode tmp = p;
        while(tmp != root){
            p_list.add(tmp);
            tmp = parent.get(tmp);
        }
        p_list.add(root);
        tmp = q;
        while(tmp != root){
            q_list.add(tmp);
            tmp = parent.get(tmp);
        }
        q_list.add(root);
        int i = 0;
        for(; i < Math.min(p_list.size(), q_list.size()); i++){
            if(p_list.get(p_list.size() - i - 1) != q_list.get(q_list.size() - i - 1)){
                break;
            }
        }
        return p_list.get(p_list.size() - i);
    }

    public static void main(String[] args) {
        TreeNode tmp = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        TreeNode left = new TreeNode(5, new TreeNode(6), tmp);
        TreeNode right= new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, left, right);
        TreeNode res = new Solution().lowestCommonAncestor(root, tmp, left);
        System.out.println(res);
    }
}
