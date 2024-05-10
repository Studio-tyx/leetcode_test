package true_test.xiaohongshu_2023;
import java.util.*;

public class RedDiary {
//    public static void run(int n, int T, int H, int[][] events){
//        int[][] dp = new int[T + 1][H + 1];
//        for (int i = 0; i < n; i++) {
//            for (int t = T; t >= events[i][0]; t--) {
//                for (int h = H; h >= events[i][1]; h--) {
//                    dp[t][h] = Math.max(dp[t][h], dp[t - events[i][0]][h - events[i][1]] + events[i][2]);
//                }
//            }
//        }
//
//        System.out.println(dp[T][H]); // 输出最终答案
//    }
    public static void run(int n, int T, int H, int[][] events){
        int[][] dp = new int[T+1][H+1];
        for(int i = 0; i <= T; i++){
            for(int j = 0; j <= H; j++){
                dp[i][j] = 0;
            }
        }
        for(int i = 0; i < n; i++){
            int[][] dp_new = new int[T+1][H+1];
            for(int j = 0; j <= T; j++){
                for(int k = 0; k <= H; k++){
                    dp_new[j][k] = 0;
                }
            }
            for(int j = 0; j <= T; j ++){
                for(int k = 0; k <= H; k++){
                    if(j >= events[i][0] && k >= events[i][1])
                        dp_new[j][k] = Math.max(dp[j][k], dp[j-events[i][0]][k-events[i][1]]+ events[i][2]);
                    else
                        dp_new[j][k] = dp[j][k];
                }
            }
            dp = dp_new;
        }
        System.out.println(dp[T][H]);
    }
    public static void scanner(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 事件数量
        int T = scanner.nextInt(); // 时间限制
        int H = scanner.nextInt(); // 精力限制

        int[][] events = new int[n][3];
        for (int i = 0; i < n; i++) {
            events[i][0] = scanner.nextInt(); // 时间
            events[i][1] = scanner.nextInt(); // 精力
            events[i][2] = scanner.nextInt(); // 快乐值
        }
        scanner.close();
        run(n, T, H, events);
    }
    public static void test_case(){
        int[][] events = new int[][]{{1,2,2},{2,1,3},{4,1,5}};
        run(3,5,4,events);
    }
    public static void main(String[] args) {
        test_case();
    }
}
