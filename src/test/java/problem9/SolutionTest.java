package problem9;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(123));
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(-121));
    }

}