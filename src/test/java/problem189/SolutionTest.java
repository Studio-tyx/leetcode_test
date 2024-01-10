package problem189;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[]{1,2,3,4,5,6,7};
        s.rotate(input, 3);
        for (int i:input){
            System.out.print(i+",");
        }
        System.out.println();

        input = new int[]{-1,-100,3,99};
        s.rotate(input, 0);
        for (int i:input){
            System.out.print(i+",");
        }
        System.out.println();
    }
}