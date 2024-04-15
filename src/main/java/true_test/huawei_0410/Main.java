//下次用华子的OJ能多做题就多做题，题目有分就可以下一题了，毕竟越后面分数越高
//傻逼OJ一点错误提示都没有的
package true_test.huawei_0410;


import java.util.*;

public class Main {
    public static void problem1(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Map<String, Map<String, Integer>> interval = new HashMap<>();
        Map<String, Map<String, String>> timestamp = new HashMap<>();
        for (int i = 0; i < n; i++){
            String line = in.nextLine();
            String[] words = line.split(",");
            int demand = Integer.parseInt(words[3]);
            if (demand > 100 || demand < 0) demand = 0;
            if (!timestamp.containsKey(words[1])){
                Map<String, Integer> client_interval = new HashMap<>();
                client_interval.put(words[2], demand);
                interval.put(words[1], client_interval);
                Map<String, String> client_timestamp = new HashMap<>();
                client_timestamp.put(words[2], words[0]);
                timestamp.put(words[1], client_timestamp);
            }
            else{
                Map<String, Integer> client_interval = interval.get(words[1]);
                if (client_interval.containsKey(words[2])){
                    int former = interval.get(words[1]).get(words[2]);
                    if (timestamp.get(words[1]).get(words[2]).equals(words[0])){
                        interval.get(words[1]).replace(words[2], Math.max(former, demand));
                    }
                    else{
                        interval.get(words[1]).replace(words[2], former+demand);
                    }
                }
                else{
                    interval.get(words[1]).put(words[2], demand);
                    timestamp.get(words[1]).put(words[2], words[1]);
                }
            }
        }
        Map<String, Integer> price = new HashMap<>();
        int m = Integer.parseInt(in.nextLine());
        for (int i = 0; i < m; i++){
            String line = in.nextLine();
            String[] words = line.split(",");
            int tmp_price = Integer.parseInt(words[1]);
            if (tmp_price > 100 || tmp_price < 1) tmp_price = 0;
            price.put(words[0], tmp_price);
        }
        String[] client_names = new String[interval.size()];
        int idx = 0;
        Map<String, Integer> sum = new HashMap<>();
        for(String client_name : interval.keySet()){
            client_names[idx ++] = client_name;
            int tmp_sum = 0;
            for (String fact : interval.get(client_name).keySet()){
                tmp_sum += interval.get(client_name).getOrDefault(fact,0) * price.getOrDefault(fact, 0);
            }
            sum.put(client_name, tmp_sum);
        }
        Arrays.sort(client_names);
        for(String client_name:client_names){
            System.out.println(client_name+","+sum.get(client_name));
        }
    }
    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Set<Integer>> sets = new ArrayList<>();
        Map<Integer, Integer> set_idx = new HashMap<>();
        Map<Integer, Integer> sums = new HashMap<>();
//        Map<Integer, Integer> xiang = new HashMap<>();
//        Map<Integer, Integer> no2set_no = new HashMap<>();

        int[][] x = new int[n][n];
        for (int i = 0; i < n; i++){
            boolean flag = false;
            for (int j = 0; j < n; j++){
                int m = in.nextInt();
//                System.out.println(m);
                x[i][j] = m;
                if (m!=0) flag =true;
                if(j >= i && m != 0){
                    boolean find = false;
                    for(int idx = 0; idx < sets.size(); idx ++){
                        if (sets.get(idx).contains(i)) {
                            find = true;
                            set_idx.put(j, set_idx.get(i));
                            sets.get(idx).add(j);
                            sums.replace(set_idx.get(j), sums.get(set_idx.get(j))+m);
                            break;
                        }
                        else if (sets.get(idx).contains(j)){
                            find = true;
                            set_idx.put(i, set_idx.get(j));
                            sets.get(idx).add(i);
                            sums.replace(set_idx.get(i), sums.get(set_idx.get(i))+m);
                            break;
                        }
                    }
                    if(find == false){
                        Set<Integer> s = new HashSet<>();
                        s.add(i);
                        s.add(j);
                        sets.add(s);
                        set_idx.put(i, sets.size() - 1);
                        set_idx.put(j, sets.size() - 1);
                        sums.put(sets.size()-1, m);
                    }
                }
            }
            if(flag == false){
                Set<Integer> s = new HashSet<>();
                sets.add(s);
                set_idx.put(i, sets.size()-1);
            }
        }
        int[] res = new int[sets.size()];
        int idx = 0;
        for(Integer s : sums.keySet()){
            res[idx++] = sums.get(s);
        }
//        for(Set<Integer> set:xiang.keySet()){
//            res[idx ++] = xiang.get(set);
//        }
        Arrays.sort(res);
        for(int i = sets.size() - 1; i >= 0; i--){
            if (i!=sets.size()-1) System.out.print(" "+res[i]);
            else System.out.print(res[i]);
        }
//        System.out.println();
    }
    public static void main(String[] args) {
        problem1();
//        problem2();
    }
}
