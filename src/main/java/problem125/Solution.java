package problem125;

public class Solution {
    public boolean isPalindrome(String s) {
            String temp = "";
            for (int i = 0; i < s.length(); i ++){
                if (s.charAt(i)>='a' && s.charAt(i)<='z'){
                    temp+=s.charAt(i);
                }
                else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                    temp+=s.charAt(i);
                }
                else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    temp+=(char)(s.charAt(i)+('a'-'A'));
                }
            }
            for(int i = 0; i < temp.length(); i++){
                if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)){
                    return false;
                }
            }
            return true;
    }
}