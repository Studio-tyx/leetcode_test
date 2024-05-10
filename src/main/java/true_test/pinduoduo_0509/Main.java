package true_test.pinduoduo_0509;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void han_bao(int n, int m){
        int res;
        int five = m/5;
        if(n/5 <= m/5) {
            res = Math.min(n / 5, five);
            int remain = n - res * 5;
            int cost = res * 5;
            if (remain >= 10 - m % 5) {
                res += remain / (10 - m % 5);
                cost += remain / (10 - m % 5) * (10 - m % 5);
            }
            System.out.println(res + " " + cost);
        }
        else{
            res = 0;
            int cost;
            for(int i = 5; i <= 10; i++){
                int group = i == 10? 0: m / (10-i);
                res = Math.min(n / i, group);
                int remain = n - res * i;
                cost = res * i;
//                if (remain >= 10 - m % (10-i)) {
//                    res += remain / (10 - m % (10-i));
//                    cost += remain / (10 - m % (10-i)) * (10 - m % (10-i));
//                }
                System.out.println(res + " " + cost);
            }
        }
    }
    public static void problem_1(){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int t = Integer.parseInt(in.nextLine());
//            String line = in.nextLine();
            String line ;
            for(int i = 0; i < t; i++){
                line = in.nextLine();
                String[] words = line.split(" ");
                int n = Integer.parseInt(words[0]);
                int m = Integer.parseInt(words[1]);
                han_bao(n, m);
            }
        }
    }

    public static void problem_3(){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            String str = in.nextLine();
            int res = 0;
            Stack<Character> stack = new Stack<>();
            Character former = ' ';
            for (int i = 0; i < n; i++){
                Character cur = str.charAt(i);
                if(!stack.isEmpty()){
                    Character old = stack.peek();
                    if(old.equals(cur)){
                        stack.pop();
                        if(!former.equals(cur)){
                            res ++;
                            former = cur;
                        }
                    }
                    else if (former.equals(cur)){

                    }
                    else {
                        stack.push(str.charAt(i));
                    }
                }
                else{
                    stack.push(str.charAt(i));
                }
            }
            res += stack.size();
            System.out.println(res);
        }
    }
    public static void problem_3_map(){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            String str = in.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++){
                Character cur = str.charAt(i);
                map.put(cur, map.getOrDefault(cur,0)+1);
            }
            System.out.println(map.size());
        }
    }

    public static void problem_4(){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            int t = Integer.parseInt(in.nextLine());
            for(int i = 0; i < t; i++){
                String[] mn = in.nextLine().split(" ");
                int n = Integer.parseInt(mn[0]);
                int m = Integer.parseInt(mn[1]);
                int[] nums = new int[n];
                int sum = 0;
                double res = 0;
                for(int j = 0; j < n; j++){
                    int x = Integer.parseInt(in.nextLine());
                    nums[j] = x;
                    sum += x;
                    if(j >= m){
                        sum -= nums[j - m];
                        System.out.println(nums[j-m]);
                    }
                    res = Math.max(res, sum);
                    System.out.println("sum"+sum+","+res);

                }
                BigDecimal num = new BigDecimal((double)res/m);
                BigDecimal san = num.setScale(3, RoundingMode.HALF_UP);
                System.out.println(san);
            }
        }
    }

    public static void problem_2(){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            int t = Integer.parseInt(in.nextLine());
            for(int i = 0; i < t; i++){
                String[] nk = in.nextLine().split(" ");
                int n = Integer.parseInt(nk[0]);
                int k = Integer.parseInt(nk[1]);
                String str = in.nextLine();
                int res;
                int count_01 = 0, count_10 = 0, count_11 = 0;
                for(int j = 0; j < n-1;j ++){
                    if(str.charAt(j) == '0' && str.charAt(j+1) == '1'){
                        count_01 ++;
                    }
                    else if(str.charAt(j) == '1' &&str.charAt(j+1) == '0'){
                        count_10 ++;
                    }
                    else{
                        count_11 ++;
                    }
                    j ++;
                }
                if(count_01 >= n/2){
                    res = count_01 * 11 + (n%2 ==0? 0: (str.charAt(n-1)=='1'?1:0));
                }
                else{
                    res = 0;
                }
                System.out.println(res);
            }
        }
    }
    public static void main(String[] args) {
        problem_1();
//        problem_2();
//        problem_3();
//        problem_4();
    }
}
