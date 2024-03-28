package problem9;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        String str = String.valueOf(x);
        int n = str.length();
        boolean flag = true;
        for (int i = 0; i < n; i++){
//            System.out.println(str.charAt(i) + ", " + str.charAt(n - i - 1));
            if (str.charAt(i) != str.charAt(n - i - 1)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
