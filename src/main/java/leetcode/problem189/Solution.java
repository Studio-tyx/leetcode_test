package problem189;

import java.util.Arrays;

public class Solution {
    public void rotate_more_space(int[] nums, int k) {
        int n = nums.length;
        int[] other = new int[n];
        System.arraycopy(nums, 0, other, 0, n);
        int idx = (n - k % n) % n;
        for (int i = 0; i < n; i++){
            nums[i] = other[idx];
            idx = (idx + 1) % n;
        }
    }

    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        int n = nums.length;
        int idx = 0;
        if (gcd(n, k) == 1){
            int tmp = nums[idx];
            for (int i = 0; i < n; i++){
                idx = (idx + k) % n;
                int next_tmp = nums[idx];
                nums[idx] = tmp;
                tmp = next_tmp;
            }
            nums[(idx + k) % n] = tmp;
        }
        else{
            for (int count = 0; count < gcd(n, k); count ++){
                idx = count;
                int tmp = nums[idx];
                idx = (idx + k) % n;
                while(idx != count){
                    int next_tmp = nums[idx];
                    nums[idx] = tmp;
                    tmp = next_tmp;
                    idx = (idx + k) % n;
                }
                nums[idx] = tmp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public void rotate_1(int[] nums, int k) {
        int n = nums.length;
        int count = gcd(n, k);
        int move = (n - k % n) % n;
        for (int start = 0; start < count; start ++){
            int current = start;
            int temp = nums[start];
            do{
                int next = (current + move) % n;
                nums[current] = nums[next];
//                System.out.print(current+","+next+"|");
//                for (int ii:nums){
//                    System.out.print(ii+",");
//                }
//                System.out.println();
                current = next;
            }while (current != start);
            nums[(current + n - move) % n] = temp;
        }
    }

//    gcd is a good thing!
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        s.rotate(new int[]{1,2,3,4,5,6,7}, 3);
//        s.rotate(new int[]{-1,-100,3,99}, 2);
        s.rotate(new int[]{1,2,3,4,5,6}, 2);
    }
}
