package problem392;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("abc", "babc"));
        System.out.println(s.isSubsequence("axc", "babc"));
        System.out.println(s.isSubsequence("aa", "baa"));
        System.out.println(s.isSubsequence("aaa", "baa"));
        System.out.println(s.isSubsequence("abc", "abx"));
    }
}