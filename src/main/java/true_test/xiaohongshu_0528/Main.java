package true_test.xiaohongshu_0528;

import java.util.*;

public class Main {
    public void problem_1(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id_str = in.nextLine();
            if(!set.contains(id_str)){
                set.add(id_str);
                res.add(id_str);
            }
        }
        for(String str:res){
            System.out.println(str);
        }
    }
    public void problem_3(){
        long mod = 1000000007;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ji = 0, ou = 0;
        long sum = 0;
        for(int i = 0; i < n; i++){
            long a = in.nextLong();
            if(a % 2 == 0) ou ++;
            else ji ++;
            sum += a;
        }
        long res = 0;
        for(int i = 1; i < 10; i++){
            res += (long) (Math.pow((double)1/n, (ji + i)) * (sum + ji + i));
        }
        System.out.println((long)sum * 2 % mod);
    }
    public List<Integer> count_zan;
    public void trace_back(int[] a, int[] cut, int x, int i, int repeat, int cur_sum){
//        if(i < 0 || i >= a.length) return;
        if(cur_sum == x && i-1 != repeat){
//            count_zan.add(cut[i]);
            min_count = Math.min(count_zan.size(), min_count);
//            System.out.println(count_zan);
        }
        else if(i < 0 || i >= a.length) return;
        else{
            trace_back(a, cut, x, i + 1, repeat, cur_sum);
            if(cur_sum + cut[i] > x) return;
            if(i != repeat) {
                count_zan.add(cut[i]);
                cur_sum += cut[i];
                trace_back(a, cut, x, i + 1, repeat, cur_sum);
                cur_sum -= cut[i];
                count_zan.remove(count_zan.size() - 1);
            }
        }
    }
    public int min_count;
    public void problem_2_input(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), x = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        problem_2(n, x, a);
    }
    public void problem_2(int n, int x, int[] a){
        Arrays.sort(a);
        int[] cut = new int[n];
        for(int i = 0; i < n; i++){
            cut[i] = a[i] / 2;
        }
        count_zan = new ArrayList<>();
        min_count = Integer.MAX_VALUE;
        trace_back(a, cut, x, 0, -1, 0);
        for(int repeat = 0; repeat < n; repeat++){
            count_zan.add(a[repeat]);
            trace_back(a, cut, x, 0, repeat, a[repeat]);
            count_zan.remove(count_zan.size() - 1);
        }
        if(min_count == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min_count);
    }
    public static void main(String[] args) {
//        new Main().problem_1();
//        new Main().problem_2_input();
//        new Main().problem_3();
        new Main().problem_2(5, 10, new int[]{1,2,3,4,10});
        new Main().problem_2(5, 6, new int[]{1,2,3,4,10});
        new Main().problem_2(5, 2, new int[]{1,2,3,4,10});
    }
}
