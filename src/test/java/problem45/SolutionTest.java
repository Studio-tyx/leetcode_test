package problem45;


import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jump(new int[]{2,3,1,1,4}));
        System.out.println(s.jump(new int[]{2,3,0,1,4}));
        System.out.println(s.jump(new int[]{1,1,1,1,1}));
    }

}