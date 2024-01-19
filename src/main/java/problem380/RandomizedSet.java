package problem380;

import java.util.*;

public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)){
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
        else return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int last = list.get(list.size() - 1);
            int idx = map.get(val);
            list.set(idx, last);
            map.put(last, idx);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        else return false;
    }

    public int getRandom() {
        return list.get(random.nextInt(map.size()));
    }
}
