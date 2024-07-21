package true_test.oppo_fake_0721;

import java.util.Scanner;

public class Main {
    public static void problem_21(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long x = in.nextLong();
        long res = 0;
        for(int i = 0; i < n; i++){
            long a = in.nextLong();
            long b = in.nextLong();
            if(x >= a){
                res += b;
                x -= a;
            }
        }
        System.out.println(res);
    }

    public static boolean isReverse(String str){
        StringBuilder reverseString = new StringBuilder(str).reverse();
        return str.contentEquals(reverseString);
    }

    public static void problem_22(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int k = in.nextInt();
        StringBuilder t = new StringBuilder();
        if(k >= s.length()){
            t = new StringBuilder(s).reverse();
            for(int i = s.length(); i < k; i++){
                t.append('a');
            }
            System.out.println(t);
        }
        else{
            String tmp_t = new StringBuilder(new StringBuilder(s).substring(0, k)).reverse().toString();
            String left_concat = s + tmp_t;
            if(isReverse(left_concat)){
                System.out.println(tmp_t);
            }
            else{
                tmp_t = new StringBuilder(new StringBuilder(s).substring(s.length() - k)).reverse().toString();
                String right_concat = tmp_t + s;
                if(isReverse(right_concat)){
                    System.out.println(tmp_t);
                }
                else{
                    System.out.println(-1);
                }
            }
        }
    }

    public static void main(String[] args) {
//        problem_21();
        problem_22();
    }
}
