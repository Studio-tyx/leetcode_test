package true_test.diezhi_0925;

import java.util.ArrayList;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param blocked_words string字符串ArrayList 屏蔽字库列表
     * @param nike_name     string字符串 需要检查的昵称
     * @return bool布尔型
     */
    public boolean CheckNikeNameIsAllowed(ArrayList<String> blocked_words, String nike_name) {
        // write code here
        for (String str : blocked_words) {
            if (nike_name.contains(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 需要计算经过的所有路点消耗值之和，终点不可达或找不到返回-1
     *
     * @param map_width  int整型 地图的宽度
     * @param map_height int整型 地图的高度
     * @param grids      int整型二维数组 网格数据
     * @param start_pos  Point类 起始位置
     * @param end_pos    Point类 终点位置
     * @return int整型
     */
    public int FindPath(int map_width, int map_height, int[][] grids, Point start_pos, Point end_pos) {
        // write code here
        int flag = 0;
        if(start_pos.x >= end_pos.x){
            Point tmp = new Point(start_pos.x, start_pos.y);
            start_pos = end_pos;
            end_pos = tmp;
            flag = 1;
        }
        int dir = 1;
        if(start_pos.y > end_pos.y) dir = -1;
        int[][] dp = new int[map_width + 2][map_height + 2];
        for(int i = 0; i <= map_width + 1; i++){
            for(int j = 0; j <= map_height + 1; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        if(dir > 0){
            for(int i = start_pos.x + 1; i <= end_pos.x + 1; i++){
                for(int j = start_pos.y + 1; j <= end_pos.y + 1; j++){
                    if(i == start_pos.x + 1 && j == start_pos.y + 1){
                        dp[i][j] = 0;
                    }
                    else {
                        int value = Integer.MAX_VALUE;
                        if(grids[i - 1][j - 1] != 0){
                            if(i - 1 >= 0 && i - 1 < map_width + 1 && j >= 0 && j < map_height + 1 && dp[i - 1][j] != Integer.MAX_VALUE){
                                value = Math.min((dp[i - 1][j] + grids[i - 1][j - 1]), (value));
                            }
                            if(i >= 0 && i < map_width + 1 && j - 1 >= 0 && j - 1 < map_height + 1 && dp[i][j - 1] != Integer.MAX_VALUE){
                                value = Math.min((dp[i][j - 1] + grids[i - 1][j - 1]),(value));
                            }
                        }
                        dp[i][j] = value;
                    }
                }
            }
        }
        if(dir > 0){
            for(int i = start_pos.x + 1; i <= end_pos.x + 1; i++){
                for(int j = start_pos.y + 1; j >= end_pos.y + 1; j--){
                    if(i == start_pos.x + 1 && j == start_pos.y + 1){
                        dp[i][j] = 0;
                    }
                    else {
                        int value = Integer.MAX_VALUE;
                        if(grids[i - 1][j - 1] != 0){
                            if(i - 1 >= 0 && i - 1 < map_width + 1 && j >= 0 && j < map_height + 1 && dp[i - 1][j] != Integer.MAX_VALUE){
                                value = Math.min((dp[i - 1][j] + grids[i - 1][j - 1]), (value));
                            }
                            if(i >= 0 && i < map_width + 1 && j + 1 >= 0 && j + 1 < map_height + 1 && dp[i][j + 1] != Integer.MAX_VALUE){
                                value = Math.min((dp[i][j + 1] + grids[i - 1][j - 1]),(value));
                            }
                        }
                        dp[i][j] = value;
                    }
                }
            }
        }
        int res = dp[end_pos.x + 1][end_pos.y + 1];
        if(res != Integer.MAX_VALUE) {
            if(flag == 1){
                res -= grids[end_pos.x][end_pos.y];
                res += grids[start_pos.x][start_pos.y];
            }
            return res;
        }
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().FindPath(6,6,
                new int[][]{{1, 3, 2, 2, 3, 0},{ 3, 0, 1, 1, 3, 2 },{ 1, 3, 2, 0, 1, 3 },{ 2, 1, 3, 3, 2, 1 },{ 1, 0, 3, 2, 2, 1 },{ 3, 2, 1, 0, 3, 2}},
                new Point(0, 0), new Point(2,2)));
        System.out.println(new Solution().FindPath(6,6,
                new int[][]{{1, 3, 2, 2, 3, 0},{ 3, 0, 1, 1, 3, 2 },{ 1, 3, 2, 0, 1, 3 },{ 2, 1, 3, 3, 2, 1 },{ 1, 0, 3, 2, 2, 1 },{ 3, 2, 1, 0, 3, 2}},
                new Point(5, 4), new Point(0,1)));
//        5,6,[[ 2, 1, 3, 0, 2, 1 ],[ 0, 3, 2, 1, 3, 0 ],[ 3, 0, 1, 2, 0, 3 ],[ 1, 2, 0, 3, 1, 2 ],[ 3, 1, 2, 0, 3, 1 ]],(4,4),(0,0)
        System.out.println(new Solution().FindPath(5,6,
                new int[][]{{2, 1, 3, 0, 2, 1 },{ 0, 3, 2, 1, 3, 0 },{ 3, 0, 1, 2, 0, 3 },{ 1, 2, 0, 3, 1, 2 },{ 3, 1, 2, 0, 3, 1}},
                new Point(4, 4), new Point(0,0)));
        System.out.println(new Solution().FindPath(5,6,
                new int[][]{{2, 1, 3, 0, 2, 1 },{ 0, 3, 2, 1, 3, 0 },{ 3, 0, 1, 2, 0, 3 },{ 1, 2, 0, 3, 1, 2 },{ 3, 1, 2, 0, 3, 1}},
                new Point(0, 0), new Point(0,1)));
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



