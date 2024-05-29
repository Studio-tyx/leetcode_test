package leetcode.problem79;

public class Solution {
    public String word;
    public boolean res = false;
    public int[] direct_i = new int[]{0, 1, 0, -1};
    public int[] direct_j = new int[]{1, 0, -1, 0};

    public boolean check(char[][] board, int i, int j){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0) return false;
        else return true;
    }
    public void trace_back(char[][] board, int[][] is_visited, String cur, int i, int j, int str_idx){
        if(!check(board, i, j)) return;
        if(board[i][j] == word.charAt(str_idx)){
            cur += board[i][j];
            if(cur.equals(word)) {
                res = true;
                return;
            }
            for(int ii = 0; ii < 4; ii ++){
                int next_i = i + direct_i[ii];
                int next_j = j + direct_j[ii];
                if(check(board, next_i, next_j) && is_visited[next_i][next_j] == 0){
                    is_visited[next_i][next_j] = 1;
                    trace_back(board, is_visited, cur, next_i, next_j, str_idx + 1);
                    is_visited[next_i][next_j] = 0;
                }
            }
        }

    }
    public boolean exist_1(char[][] board, String word) {
        this.word = word;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    int[][] is_visited = new int[board.length][board[0].length];
                    is_visited[i][j] = 1;
                    trace_back(board, is_visited, "", i, j, 0);
                    if(res) break;
                }
            }
        }
        return res;
    }
    public boolean dfs(char[][] board, int[][] is_visited, int i, int j, String word, int str_idx, String cur){
        if(!check(board, i, j) || cur.length() > word.length()) return false;
        if(word.charAt(str_idx) != board[i][j] || is_visited[i][j] == 1) return false;
        if(cur.length() == word.length() - 1) return true;
        else{
            cur += word.charAt(str_idx);
            boolean tmp_res = false;
            is_visited[i][j] = 1;
            for(int ii = 0; ii < 4 && !res; ii++){
                tmp_res = tmp_res || dfs(board, is_visited, i + direct_i[ii], j + direct_j[ii], word, str_idx + 1, cur);
            }
            is_visited[i][j] = 0;
            return tmp_res;
        }
    }
    public boolean exist(char[][] board, String word){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, new int[board.length][board[0].length], i, j, word, 0, "")) return true;

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCEFSADEESE"));
        System.out.println(new Solution().exist(new char[][]{{'A'}}, "A"));
        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCE"));
        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }
}
