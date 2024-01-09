package problem80;


import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates_count(new int[]{1,1,1,2,2,3}));
        System.out.println(s.removeDuplicates_count(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(s.removeDuplicates_count(new int[]{1,2,2}));

    }
}