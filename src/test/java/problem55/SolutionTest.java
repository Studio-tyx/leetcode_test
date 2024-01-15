package problem55;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{2,3,1,1,4}));
        System.out.println(s.canJump(new int[]{3,2,1,0,4}));
        System.out.println(s.canJump(new int[]{2,0}));
        System.out.println(s.canJump(new int[]{0}));
    }
}