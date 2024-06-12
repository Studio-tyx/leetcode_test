package leetcode.problem394;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int start = i;
                while(s.charAt(i) != '['){
                    i ++;
                }
                stack.push(s.substring(start, i));
            }
            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                stack.push(s.substring(i, i + 1));
            }
            else if(s.charAt(i) == ']'){
                StringBuilder tmp = new StringBuilder();
                while(!(stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')){
                    tmp.append(stack.pop());
                }

                int repeat = Integer.parseInt(stack.pop());
                String next_add = "";
                for(int j = 0; j < repeat; j++){
                    next_add += tmp;
                }
                stack.push(next_add);
            }
        }
        String res_reverse = "";
        while(!stack.isEmpty() && !(stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')){
            res_reverse += stack.pop();
        }
        String res = "";
        for(int i = res_reverse.length() - 1; i >= 0; i--){
            res += res_reverse.substring(i, i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Solution().decodeString("abc3[cd]xyz"));
        System.out.println(new Solution().decodeString("100[leetcode]"));

    }
}
