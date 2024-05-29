package leetcode.A_summary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlideWindow {
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++){
            if (!count.containsKey(p.charAt(i))){
                count.put(p.charAt(i), 1);
                map.put(p.charAt(i), 0);
            }
            else count.replace(p.charAt(i), count.get(p.charAt(i))+1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()){
            char ch = s.charAt(right);
            right ++;
            if (count.containsKey(ch)){
                map.replace(ch, map.get(ch) + 1);
                if (map.get(ch).equals(count.get(ch))){
                    valid ++ ;
                }
            }
            while (right - left >= p.length()){
                if (valid == count.size()){
                    res.add(left);
                }
                char cc = s.charAt(left);
                if (count.containsKey(cc)){
                    if (map.get(cc).equals(count.get(cc))){
                        valid --;
                    }
                    map.replace(cc, map.get(cc) - 1);
                }
                left ++;
            }
        }
        return res;
    }
}
