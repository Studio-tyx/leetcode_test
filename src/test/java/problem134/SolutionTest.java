package problem134;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(s.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
        System.out.println(s.canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
    }
}