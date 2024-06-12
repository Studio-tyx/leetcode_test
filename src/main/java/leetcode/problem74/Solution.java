package leetcode.problem74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col_left = 0, col_right = m - 1;
        while(col_left <= col_right){
            int mid = (col_left + col_right) / 2;
            if(matrix[mid][0] == target) return true;
            if(col_left == col_right - 1 && matrix[col_left][0] <= target && matrix[col_right][0] > target) break;
//            if(col_left + 1 == col_right && matrix[col_left][0] < target && matrix[col_right][0] > target) break;
            else if(matrix[mid][0] < target) col_left = mid + 1;
            else col_right = mid - 1;
            if(col_left == col_right - 1 && matrix[col_left][0] < target && matrix[col_right][0] > target){
                col_left --;
                break;
            }
        }
        if(col_left >= col_right) col_left --;
        col_left = Math.max(0, col_left);
        int row_left = 0, row_right = n - 1;
        while(row_left <= row_right){
            int mid = (row_left + row_right) / 2;
            if(matrix[col_left][mid] == target) return true;
            else if(matrix[col_left][mid] < target) row_left = mid + 1;
            else row_right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{{-9,-7,-7,-5,-3},{-1,0,1,3,3},{5,7,9,11,12},{13,14,15,16,18},{19,21,22,22,22}}, -4));
        System.out.println(new Solution().searchMatrix(new int[][]{{1}, {3}}, 3));
        System.out.println(new Solution().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 10));
        System.out.println(new Solution().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(new Solution().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
        System.out.println(new Solution().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 0));
        System.out.println(new Solution().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 8));
        System.out.println(new Solution().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 7));
        System.out.println(new Solution().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 70));
        System.out.println(new Solution().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 20));
    }
}
