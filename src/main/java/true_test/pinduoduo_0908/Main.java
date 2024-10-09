package true_test.pinduoduo_0908;

import java.util.Scanner;

public class Main {
    public void problem_1(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String queue = in.nextLine();
        int res = 0;
        int[][] dp = new int[n][n];
        for(int mid = 0; mid < n; mid ++){
            dp[mid][0] = 0;
        }
        for(int length = 1; length <= n / 2 + 1; length ++){
            for(int mid = 0; mid < n; mid++){
                if(mid - length + 1 >= 0 && mid + length < n){
                    dp[mid][length] = -1;
                    if(dp[mid][length - 1] != -1){
                        if((queue.charAt(mid - length + 1) == 'A' && queue.charAt(mid + length) == 'B')||
                            queue.charAt(mid - length + 1) == 'B' && queue.charAt(mid + length) == 'A'){
                            dp[mid][length] = dp[mid][length - 1] + 2;
                            res = Math.max(res, dp[mid][length]);
                        }
                    }
                    else{
                        if(judge(queue, mid - length + 1, mid + length)){
                            res = Math.max(res, length * 2);
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

    public void problem_1_dp(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String queue = in.nextLine();
        int res = 0;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 0;
        }
        for(int i = 0; i < n - 1; i++){
            dp[i][i + 1] = -1;
        }
        for(int length = 1; length < n; length += 2){
            for(int i = 0; i < n; i++){
                if(i + length < n) {
                    dp[i][i + length] = -1;
                    if (dp[i + 1][i + length - 1] != -1 &&
                            ((queue.charAt(i) == 'A' && queue.charAt(i + length) == 'B') ||
                                    (queue.charAt(i) == 'B' && queue.charAt(i + length) == 'A'))) {
                        dp[i][i + length] = 0;
                        res = Math.max(res, length + 1);
                    }
                    for (int mid = i; mid <= i + length; mid++) {
                        if (dp[i][mid] != -1 && dp[mid][i + length] != -1) {
                            dp[i][i + length] = 0;
                            res = Math.max(res, length + 1);
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

    public boolean judge(String in, int start, int end){
        int i = start;
        int count_A = 0, count_B = 0;
        while(i <= Math.min(end, in.length())){
            if(in.charAt(i) == 'A') count_A ++;
            if (in.charAt(i) == 'B') count_B ++;
            i ++;
        }
        if(count_A == count_B) return true;
        else return  false;
    }

    public void problem_1_baoli(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String queue = in.nextLine();
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(judge(queue, i, j)){
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        System.out.println(res);
    }

    public long get_max(long[] a, int n){
        long[] left = new long[n + 1];
        left[0] = 0;
        long left_min = Long.MAX_VALUE;
        long res = 0;
        for(int i = 0; i < n; i++){
            left_min = Math.min(left_min, left[i]);
            left[i + 1] = left[i] + a[i];
            res = Math.max(res, left[i + 1] - left_min);
        }
        System.out.println("max:" + res);
        return res;
    }
    public void problem_2(){
//        大概知道问题在哪儿了，但是已经不想动了
        long MAX = (long) (Math.pow(10, 9) + 7);
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int T_i = 0; T_i < T; T_i ++){
            int n = in.nextInt(), k = in.nextInt();
            long sum = 0;
            long[] a = new long[n];
            for(int i = 0; i < n; i++){
                a[i] = in.nextInt();
                sum += a[i];
            }
            long tmp_range = get_max(a, n);
            for(int i = 0; i < k; i++){
                sum += tmp_range;
                tmp_range *= 2;
                sum = sum % MAX;
            }
            System.out.println((sum + MAX) % MAX);
        }
    }
    public static void main(String[] args) {
        Main m = new Main();
//        m.problem_1();
        m.problem_1_dp();
//        m.problem_1_baoli();
//        m.problem_2();
    }
}
