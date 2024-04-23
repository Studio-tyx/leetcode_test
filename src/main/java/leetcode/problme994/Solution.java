package leetcode.problme994;

import java.util.*;

public class Solution {
    public boolean check_bound(int m, int n, int i, int j){
        if (i >= m || i < 0) return false;
        if (j >= n || j < 0) return false;
        return true;
    }
    public String convert_array(Integer[] array){
        return array[0]+","+array[1];
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer[]> cur = new HashSet<>();
        int sum  = 0;
        Map<String, Integer[]> map = new HashMap<>();
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1) sum ++;
                if (grid[i][j] == 2) {
                    Integer[] tmp = new Integer[]{i, j};
                    cur.add(tmp);
                    map.put(tmp[0] + "," + tmp[1], tmp);
                }
            }
        }
        int count = 0;
        int level = 0;
        Integer[][] direct = new Integer[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!cur.isEmpty()){
            Set<Integer[]> next_cur = new HashSet<>();
            for (Integer[] pos: cur){
                if (grid[pos[0]][pos[1]] == 1){
                    grid[pos[0]][pos[1]] = 2;
                    count ++;
                }
                for(int i = 0; i < 4; i++){
                    Integer[] tmp = new Integer[]{pos[0]+direct[i][0], pos[1]+direct[i][1]};
                    if (check_bound(m,n,tmp[0], tmp[1]) && grid[tmp[0]][tmp[1]] == 1 && !map.containsKey(convert_array(tmp))){
                        next_cur.add(tmp);
                        map.put(tmp[0] + "," + tmp[1], tmp);
                    }
                }
            }
            level ++;
            cur = next_cur;
        }
        if (count == sum){
            if (sum == 0) return 0;
            else return level - 1;
        }
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().orangesRotting(new int[][]{{0}}));
        System.out.println(new Solution().orangesRotting(new int[][]{{0,0,0},{0, 2, 1},{0,0,0}}));
        System.out.println(new Solution().orangesRotting(new int[][]{{0,0,0},{0, 2, 0},{0,0,0}}));
        System.out.println(new Solution().orangesRotting(new int[][]{{2, 1, 1},{1, 1, 0},{0, 1, 1}}));
        System.out.println(new Solution().orangesRotting(new int[][]{{2, 1, 1},{0, 1, 1},{1, 0, 1} }));
    }
}
