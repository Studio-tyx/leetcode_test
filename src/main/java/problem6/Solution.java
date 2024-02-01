package problem6;

public class Solution {
    public String convert(String s, int numRows) {
        int rows = 1200;
        int columns = 1200;
        char[][] charArray = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                charArray[i][j] = ' ';  // 可以将 'a' 替换为你想要的字符
            }
        }
        int way = 1;
        int x = 0;
        int y = 0;
        if(numRows == 1) return s;

        for (int i = 0; i < s.length(); i++){
            if (way == 1){
                charArray[x][y] = s.charAt(i);
                y ++;
                if (y == numRows){
                    x ++;
                    way = -1;
                    y = y - 2;
                }
            }
            else if (way == -1){
                charArray[x][y] = s.charAt(i);
                y --;
                if (y == -1){
                    x ++;
                    way = 1;
                    y = y + 2;
                }
            }
            else {

            }
        }
        String res = "";
        for (int j = 0; j < numRows; j ++){
            for (int i = 0; i < rows; i++){
                if (charArray[i][j]!= ' ') res += charArray[i][j];
            }
        }
        return res;
    }
}
