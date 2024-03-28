package problem189;

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
}
