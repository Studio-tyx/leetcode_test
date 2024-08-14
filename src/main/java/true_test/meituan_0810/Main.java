package true_test.meituan_0810;

import java.util.*;

public class Main {
    public void problem_1(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Map<Integer, Set<String>> count = new HashMap<>();
        int min_try = 0;
        String correct = in.nextLine();
        int correct_length = correct.length();
        for(int i = 0; i < n; i++){
            String input = in.nextLine();
            int length = input.length();
            if(count.containsKey(length)){
                Set<String> set = count.get(length);
                if(!set.contains(input)) {
                    if(correct_length > length) min_try += 1;
                    set.add(input);
                    count.put(length, set);
                }
            }
            else{
                Set<String> set = new HashSet<>();
                if(correct_length > length) min_try += 1;
                set.add(input);
                count.put(length, set);
            }
        }
        int max_try = min_try + count.get(correct_length).size();
        min_try ++;
        System.out.println(min_try + " " + max_try);
    }

    public void problem_2(){
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for(int T_i = 0; T_i < T; T_i++){
            String[] nkx = in.nextLine().split(" ");
            int n = Integer.parseInt(nkx[0]);
            long k = Long.parseLong(nkx[1]);
            long x = Long.parseLong(nkx[2]);
            int[] a = new int[n];
            for(int i = 0; i < n; i ++){
                a[i] = in.nextInt();
            }
            in.nextLine();
            Set<Integer> nums = new HashSet<>();
            int[] minFeiFus = new int[n + 1];
            int minFeiFu = 0;
            for(int i = n - 1;i >= 0; i--){
                nums.add(a[i]);
                while(nums.contains(minFeiFu)){
                    minFeiFu ++;
                }
                minFeiFus[i] = minFeiFu;
            }
            minFeiFus[n] = 0;
            long sum = Long.MAX_VALUE;
            for(int i = -1; i < n; i++){
                sum = Math.min(sum, (i + 1) * x + minFeiFus[i + 1] * k);
            }
            System.out.println(sum);
        }

    }

    public void problem_3(){
        Scanner in = new Scanner(System.in);
        String[] nq = in.nextLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        long[] a = new long[n];
        for(int i = 0; i < n; i ++){
            a[i] = in.nextLong();
        }
        in.nextLine();
        for(int i = 0; i < q; i++){
            String[] cx = in.nextLine().split(" ");
            long x = Long.parseLong(cx[1]);
            if(cx[0].equals("C")){

            }
            else if(cx[1].equals("L")){

            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.problem_1();
//        m.problem_2();
//        m.problem_3();
    }
}
