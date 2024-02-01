package problem6;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("PAYPALISHIRING", 3));//"PAHNAPLSIIGYIR"
        System.out.println(s.convert("PAYPALISHIRING", 4));//"PINALSIGYAHRPI"
        System.out.println(s.convert("A", 1));
        System.out.println(s.convert("AB", 1));
        System.out.println(s.convert("ABC", 2));
        System.out.println(s.convert("ABCD", 3));
    }
}
