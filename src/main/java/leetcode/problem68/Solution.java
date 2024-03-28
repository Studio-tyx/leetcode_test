package problem68;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        List<String> current = new ArrayList<>();
        int sum_length = 0;
        do {
            if(sum_length + words[idx].length() + current.size() > maxWidth){
                String temp = "";
                int remain_space = maxWidth - sum_length;
                for (int i = 0; i < current.size(); i++){
                    temp += current.get(i);
                    if (i == current.size() - 1 && i != 0) break;
                    if (i == current.size() - 1 && i == 0){
                        for (int j = 0; j < remain_space; j++) temp += ' ';
                        break;
                    }
//                    temp += Math.ceil((double)remain_space / (current.size()-i-1));
                    for (int j = 0; j < Math.ceil((double)remain_space / (current.size()-i-1)); j ++){
                        temp += ' ';
                    }
                    remain_space -= Math.ceil((double)remain_space / (current.size()-i-1));
                }
                res.add(temp);
                current = new ArrayList<>();
                current.add(words[idx]);
                sum_length = words[idx].length();
            }
            else {
                current.add(words[idx]);
                sum_length += words[idx].length();
            }
            idx ++;
        }
        while(idx < words.length);
        if(true){
            String temp = "";
            for (int i = 0; i < current.size(); i++){
                temp += current.get(i);
                if (i != current.size() - 1) temp += ' ';
            }
            for (int i = 0; i < (maxWidth - sum_length - current.size() + 1); i++){
                temp += ' ';
            }
            res.add(temp);
        }
        return res;
    }
}
