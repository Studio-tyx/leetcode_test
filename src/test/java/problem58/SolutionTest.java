package problem58;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("Hello World"));
        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(s.lengthOfLastWord("luffy is still joyboy"));
    }
}