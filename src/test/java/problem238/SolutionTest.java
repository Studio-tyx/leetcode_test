package problem238;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{5,9,2,-9,-9,-7,-8,7,-9,10})));
    }

}