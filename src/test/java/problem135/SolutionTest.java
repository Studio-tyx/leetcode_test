package problem135;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.candy(new int[]{1,0,2}));
        System.out.println(s.candy(new int[]{1,2,2}));
    }
}