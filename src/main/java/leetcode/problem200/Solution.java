package leetcode.problem200;

public class Solution {
    int res = 0;
    public void dfs(char[][] grid, int row, int col){
        if (!check_bound(grid, row, col)) return;
        if (grid[row][col] == '0') return;
        if (grid[row][col] == '2') return;
        grid[row][col] = '2';

        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row - 1, col);
        dfs(grid, row, col - 1);
    }

    public boolean check_bound(char[][] grid, int row, int col){
        if (row >= grid.length || row < 0) return false;
        if (col >= grid[0].length || col < 0) return false;
        return true;
    }
    public int numIslands(char[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1') {
                    res ++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(new Solution().numIslands(grid));
    }
}
