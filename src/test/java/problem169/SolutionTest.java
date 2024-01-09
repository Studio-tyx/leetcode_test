package problem169;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[]{3, 2, 3}));
        System.out.println(s.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}