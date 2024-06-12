package leetcode.problem118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(tmp);
        for(int i = 1; i < numRows; i++){
            tmp = new ArrayList<>();
            tmp.add(1);
            List<Integer> last = res.get(res.size() - 1);
            for(int j = 0; j < last.size() - 1; j ++){
                tmp.add(last.get(j) + last.get(j + 1));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(1));
        System.out.println(new Solution().generate(5));
    }
}
