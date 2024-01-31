package problem151;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("the sky is blue"));
        System.out.println(s.reverseWords("  hello world  "));
        System.out.println(s.reverseWords("a good   example"));
    }
}