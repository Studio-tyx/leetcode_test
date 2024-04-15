package leetcode.problem240;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int line = 0;
        while (line < n){
            if (matrix[line][m-1] < target){
                line ++;
            }
            else if (matrix[line][m-1] == target){
                return true;
            }
            else{
                break;
            }
        }
        if (line == n) return false;
        int col = m-1;
        for (;line < n; line ++){
            for (; col >= 0; col -- ){
                if (matrix[line][col] < target){
                    break;
                }
                else if (matrix[line][col] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        System.out.println(s.searchMatrix(input, 5));
//        System.out.println(s.searchMatrix(input, 22));
//        System.out.println(s.searchMatrix(input, 20));
//        System.out.println(s.searchMatrix(input, 31));
//        System.out.println(s.searchMatrix(input, 0));
//        System.out.println(s.searchMatrix(input, 4));
        input = new int[][]{{-1, 3}};
        System.out.println(s.searchMatrix(input,3));
    }
}
