package problem12;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(12));
        System.out.println(s.intToRoman(1994));
        System.out.println(s.intToRoman(8));
        System.out.println(s.intToRoman(9));
        System.out.println(s.intToRoman(4));
    }
}