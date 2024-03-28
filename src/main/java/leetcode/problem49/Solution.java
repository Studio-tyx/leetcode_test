package leetcode.problem49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String ret_str = Arrays.toString(ch);
            if(m.containsKey(ret_str)){
                m.get(ret_str).add(str);
            }
            else{
                List<String> sts = new ArrayList<>();
                sts.add(str);
                m.put(ret_str, sts);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String ch : m.keySet()){
            System.out.println(ch+","+m.get(ch));
            res.add(m.get(ch));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
