// 说实话感觉自己搞复杂了hhhh因为最近在搞merkle tree
// 官方题解真的很有意思了，左边数的总和和右边数的总和，有点dp那个味道了，真的很灵

package problem238;

import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++){
            left[i] = left[i-1] * nums[i];
        }
        right[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--){
            right[i] = right[i+1] * nums[i];
        }
        int[] res = new int[n];
        res[0] = right[1];
        res[n-1] = left[n-2];
        for (int i = 1; i < n-1; i++){
            res[i] = left[i-1] * right[i+1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1,2,3,4})));
    }
    public int[] productExceptSelf_1(int[] nums) {
        int n = nums.length;
        ArrayList<TreeNode> current = new ArrayList<>();
        for (int i = 0; i < n; i++){
            TreeNode tn = new TreeNode(nums[i], null, null);
            current.add(tn);
        }
        if (n % 2 == 1) current.add(new TreeNode(1, null, null));
        while(current.size() != 1){
            ArrayList<TreeNode> next = new ArrayList<>();
            int idx = 0;
            while(idx < current.size()){
                idx ++;
                TreeNode left = current.get(idx-1);
                TreeNode right;
                if(idx == current.size()){
                    right = new TreeNode(1, null, null);
                }
                else {
                    right = current.get(idx);
                }
                next.add(new TreeNode(left.val * right.val, left, right));
                idx ++;
            }
            current = next;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            TreeNode root = current.get(0);
            int mul = 1;
            int[] bits = get_bits(i, n);
            int pointer = 0;
            while (root.left != null && root.right != null) {
                if (bits[pointer] == 1) {
                    mul *= root.left.val;
                    root = root.right;
                }
                else {
                    mul *= root.right.val;
                    root = root.left;
                }
                pointer ++ ;
            }
            res[i] = mul;
        }
        return res;
    }

    public int[] get_bits(int num, int length){
        ArrayList<Integer> result = new ArrayList<>();
        int n = (int) Math.ceil(Math.log(length) / Math.log(2));
        if (num == 0){
            for (int i =0; i < n; i++) {
                result.add(0);
            }
        }
        else {
            while (num != 1) {
                result.add(num % 2);
                num = num / 2;
            }
            result.add(1);
            if (result.size() < n) {
                for (int i = result.size(); i < n; i++) {
                    result.add(0);
                }
            }
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--){
            res[n - 1 - i] = result.get(i);
        }
        return res;
    }

//    public void show_node(TreeNode node){
//        System.out.print(node.val+",");
//        if (node.left != null)  show_node(node.left);
//        if (node.right!= null)  show_node(node.right);
//    }
}
