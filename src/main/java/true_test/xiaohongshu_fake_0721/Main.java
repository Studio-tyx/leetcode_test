package true_test.xiaohongshu_fake_0721;

import javax.xml.transform.Source;
import java.util.*;

public class Main {
    public static void problem_15(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int T = in.nextInt(), H = in.nextInt();
        int[] t = new int[n];
        int[] h = new int[n];
        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            t[i] = in.nextInt();
            h[i] = in.nextInt();
            a[i] = in.nextLong();
        }
        long[][][] dp = new long[n + 1][T + 1][H + 1];
        for(int i = 0; i < T + 1; i++){
            dp[0][i][0] = 0;
        }
        for(int i = 0; i < H + 1; i++){
            dp[0][0][i] = 0;
        }
        for(int count = 0; count < n; count++) {
            for (int i = 0; i <= T; i++) {
                for (int j = 0; j <= H; j++) {
                    if(i >= t[count] && j >= h[count]){
                        dp[count + 1][i][j] = Math.max(dp[count][i - t[count]][j - h[count]] + a[count], dp[count][i][j]);
                    }
                    else dp[count + 1][i][j] = dp[count][i][j];
                }
            }
        }
        System.out.println(dp[n][T][H]);
    }

    public static void problem_2(){
        Scanner in = new Scanner(System.in);
        String total_strings = in.nextLine();
        String[] strings = total_strings.split(" ");
        Map<String, Integer> count = new HashMap<>();
        for(String str:strings){
            count.put(str, count.getOrDefault(str, 0) + 1);
        }
        Map<Integer, String> index = new HashMap<>();
        int index_i = 0;
        int[][] sort_array = new int[count.size()][2];
        for(String str: count.keySet()){
            if(count.get(str) >= 3){
                index.put(index_i, str);
                sort_array[index_i][0] = index_i;
                sort_array[index_i][1] = count.get(str);
                index_i ++;
            }
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return index.get(o1[0]).compareTo(index.get(o2[0]));
                }
                else return - (o1[1] - o2[1]);
            }
        };
        Arrays.sort(sort_array, comparator);
        for(int i = 0; i < index_i; i++){
            System.out.println(index.get(sort_array[i][0]));
        }

    }
    public static void main(String[] args) {
//        problem_15();
        problem_2();
    }
}
