package problem34;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(s.trap(new int[]{4,2,0,3,2,5}));
    }
}