package problem28;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr( "sadbutsad", "sad"));
        System.out.println(s.strStr( "leetcode", "leeto"));
        System.out.println(s.strStr( "aaaaaaa", "a"));
    }
}