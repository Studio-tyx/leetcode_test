package leetcode.problem51;
import java.util.*;
public class Solution {
    public boolean check_valid(List<String> board){
//        Set<Integer> lines = new HashSet<>();
//        Set<Integer> cols = new HashSet<>();
        Set<Integer> left_diag = new HashSet<>();
        Set<Integer> right_diag = new HashSet<>();
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board.get(0).length(); j ++){
                if(board.get(i).charAt(j) == 'Q') {
//                    if(lines.contains(i) || cols.contains(j) || left_diag.contains(i-j) || right_diag.contains(i + j)) return false;
                    if(left_diag.contains(i-j) || right_diag.contains(i + j)) return false;
//                    lines.add(i);
//                    cols.add(j);
                    left_diag.add(i - j);
                    right_diag.add(i + j);
                }
            }
        }
//        if(lines.size() != board.size() || cols.size() != board.size() || left_diag.size() != board.size() || right_diag.size() != board.size()) return false;
//        if(left_diag.size() != board.size() || right_diag.size() != board.size()) return false;
        return true;
    }
    public List<List<String>> res;
    public void trace_back(int n, int line, List<String> cur_solution, Set<Integer> used){
        if(line >= n){
            if(check_valid(cur_solution)){
                res.add(new ArrayList<>(cur_solution));
            }
        }
        else{
            for(int col = 0; col < n; col++){
                if(used.contains(col)) continue;
                String line_str = "";
                for(int i = 0; i < n; i++){
                    if(i != col) line_str += '.';
                    else line_str += 'Q';
                }
                cur_solution.add(line_str);
                used.add(col);
                trace_back(n, line + 1, cur_solution, new HashSet<>(used));
                used.remove(col);
                cur_solution.remove(cur_solution.size() - 1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        trace_back(n, 0, new ArrayList<>(), new HashSet<>());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
        System.out.println(new Solution().solveNQueens(1));
        System.out.println(new Solution().solveNQueens(8));
    }
}
