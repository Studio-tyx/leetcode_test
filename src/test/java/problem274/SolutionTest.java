package problem274;


import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hIndex(new int[]{3,0,6,1,5}));
        System.out.println(s.hIndex(new int[]{1,3,1}));
        System.out.println(s.hIndex(new int[]{0,0,0}));
        System.out.println(s.hIndex(new int[]{1,1}));
        System.out.println(s.hIndex(new int[]{1}));
        System.out.println(s.hIndex(new int[]{0}));
        System.out.println(s.hIndex(new int[]{100}));
    }
}