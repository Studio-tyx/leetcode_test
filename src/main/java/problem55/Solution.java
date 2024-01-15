package problem55;


public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int now_need = 1;
        boolean res = false;
        if (nums.length == 1) return true;
        for (int i = n-2; i >= 0; i--){
            if (nums[i] < now_need){
                now_need ++;
                res = false;
            }
            else {
                now_need = 1;
                res = true;
            }
        }
        return res;
    }
}
