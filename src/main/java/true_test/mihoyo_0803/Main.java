package true_test.mihoyo_0803;

import java.util.*;

public class Main {
    public static void problem_1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        in.nextLine();
        for(int i = 0; i < n; i++){
            String line = in.nextLine();
            String[] words = line.split(" ");
            w[i] = Integer.parseInt(words[0]);
            v[i] = Integer.parseInt(words[1]);
        }
        Map<Integer, Set<Integer>> conflicts = new HashMap<>();
        for(int i = 0; i < k; i++){
            int a = in.nextInt(), b = in.nextInt();
            if(conflicts.containsKey(a)){
                Set<Integer> conflictSet = conflicts.get(a);
                conflictSet.add(b);
                conflicts.put(a, conflictSet);
            }
            else{
                Set<Integer> conflictSet = new HashSet<>();
                conflictSet.add(b);
                conflicts.put(a, conflictSet);
            }
            if(conflicts.containsKey(b)){
                Set<Integer> conflictSet = conflicts.get(b);
                conflictSet.add(a);
                conflicts.put(b, conflictSet);
            }
            else{
                Set<Integer> conflictSet = new HashSet<>();
                conflictSet.add(a);
                conflicts.put(b, conflictSet);
            }
        }
        long[][] dp = new long[n+1][m+1];
        int[][] solutions = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
            solutions[i][0] = 0;
        }
        for(int i = 0; i <= m; i++){
            dp[0][i] = 0;
            solutions[0][1] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = dp[i-1][j];
                solutions[i][j] = solutions[i-1][j];
                if(j >= w[i-1]){
                    if(dp[i-1][j-w[i-1]] + v[i-1] > dp[i][j]){
                        boolean flag = false;
                        Set<Integer> current = conflicts.getOrDefault(i, new HashSet<>());
                        for(Integer no:current){
                            if((solutions[i-1][j-w[i-1]] & 1 << no) != 0) {
                                flag = true;
                                break;
                            }
                        }
                        if(!flag) {
                            dp[i][j] = dp[i - 1][j - w[i-1]] + v[i-1];
                            solutions[i][j] = solutions[i-1][j-w[i-1]] | (1 << i);
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
    }


    public static void main(String[] args) {
        problem_1();
    }
}
