package problem13;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("MCMXCIV"));
        System.out.println(s.romanToInt("LVIII"));
        System.out.println(s.romanToInt("IX"));
        System.out.println(s.romanToInt("III"));
    }
}