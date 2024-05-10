package true_test.xiaohongshu_2023;

import java.util.*;

public class Main {
    public static void scanner(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while(in.hasNext()){
            String line = in.nextLine();
            String[] input = line.split(" ");
            count(input);
        }
    }
    public static void test(){
        String[] array = {
                "kou", "red", "game", "red", "ok", "who", "game", "red", "karaoke", "yukari",
                "kou", "red", "red", "nani", "kou", "can", "koukou", "ongakugame", "game"
        };
        count(array);
    }
    public static void count(String[] input){
        Map<String, Integer> map = new HashMap<>();
        for(String s:input){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        int index = 0 ;
        Map<Integer, String> idx = new HashMap<>();
        Integer[][] array = new Integer[map.size()][2];
        for(String s:map.keySet()){
            if(map.get(s) >= 3) {
                array[index][0] = map.get(s);
                array[index][1] = index;
                idx.put(index++, s);
            }
        }
        Comparator<Integer[]> c = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[0].equals(o2[0])){
                    return idx.get(o1[1]).compareTo(idx.get(o2[1]));
                }
                else{
                    return -Integer.compare(o1[0], o2[0]);
                }
            }
        };
        Arrays.sort(array, 0, idx.size(), c);
        for(int i = 0; i < idx.size(); i++){
            System.out.println(idx.get(array[i][1]));
        }
    }
    public static void main(String[] args) {
//        test();
        scanner();
    }
}
