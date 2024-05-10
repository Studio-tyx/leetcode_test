package leetcode.problem105;
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        if(inorder.length == 0) return null;
        int root = preorder[0];
        TreeNode res = new TreeNode(root);
        int idx = 0;
        while(inorder[idx] != root){
            idx ++;
        }
        int[] left_pre = new int[idx];
        int[] left_in = new int[idx];
        int[] right_pre = new int[preorder.length - idx - 1];
        int[] right_in = new int[preorder.length - idx - 1];
        for(int i = 1; i < preorder.length; i ++){
            if(i <= idx){
                left_pre[i-1] = preorder[i];
                left_in[i-1] = inorder[i-1];
            }
            else{
                right_pre[i-idx-1] = preorder[i];
                right_in[i-idx-1] = inorder[i];
            }
        }
        res.left = buildTree(left_pre, left_in);
        res.right = buildTree(right_pre, right_in);
        return res;
    }

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
