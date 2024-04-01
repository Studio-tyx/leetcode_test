package true_test.tencent_0331;

import java.util.*;

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
}
public class Main {
    public static void solution1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt();
            String rw = in.next();
            if (!map.containsKey(u)) map.put(u, true);
            if (!map.containsKey(v)) map.put(v, true);
            if (rw.equals("W")) {
                map.replace(u, false);
                map.replace(v, false);
            }
        }
        int res = 0;
        for (Integer node: map.keySet()){
            if (!map.get(node)) res ++;
        }
        System.out.println(n - res);
    }
    public static void solution2(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode[] tmp = new ListNode[2];
        int n = tmp.length;
    }

    public static void solution3(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Map<Integer, Set<Integer>> map = new LinkedHashMap<>();
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i ++){
            int u = in.nextInt(), v = in.nextInt();
            if (map.containsKey(u)){
                Set<Integer> s = map.get(u);
                s.add(v);
                map.put(v, s);
            }
            else if (map.containsKey(v)){
                Set<Integer> s = map.get(v);
                s.add(u);
                map.put(u, s);
            }
            else{
                Set<Integer> s = new HashSet<>();
                s.add(u);
                s.add(v);
                list.add(s);
                map.put(u, s);
                map.put(v, s);
            }
        }
        int res = 1;
        for (Set<Integer> s:list){
            res *= s.size();
        }
        System.out.println(res);
    }

    public static boolean check_bound(int i, int j, int n, int m){
        if (i >= 0 && i < n && j >= 0 && j < m) return true;
        else return false;
    }
    public static void solution5(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        char [][] matrix = new char[n][m];
        List<Integer> queue_x = new ArrayList<>();
        List<Integer> queue_y = new ArrayList<>();
        for (int i = 0; i < n; i++){
            String line = in.next();
            for (int j = 0; j < m; j ++){
                matrix[i][j] = line.charAt(j);
                if (line.charAt(j) == 't'){
                    queue_y.add(j);
                    queue_x.add(i);
                }
            }
        }
        char[] comp = new char[]{'t', 'e', 'n', 'c', 'e', 'n', 't'};
        int [] delta_x = new int[]{0, 1, 0, -1};
        int [] delta_y = new int[]{1, 0, -1, 0};
        for (int i = 1; i < comp.length; i++){
            List<Integer> new_x = new ArrayList<>();
            List<Integer> new_y = new ArrayList<>();
            for (int idx = 0; idx < queue_x.size(); idx ++){
                for(int dir = 0; dir < 4; dir++){
                    int next_x = queue_x.get(idx) + delta_x[dir];
                    int next_y = queue_y.get(idx) + delta_y[dir];
                    if (check_bound(next_x, next_y, n, m)){
                        if (matrix[next_x][next_y] == comp[i]){
                            new_x.add(next_x);
                            new_y.add(next_y);
                        }
                    }
                }
            }
            queue_x = new_x;
            queue_y = new_y;
        }
        System.out.println(queue_x.size());
    }
    public static void main(String[] args) {
//        solution1();
//        solution2();
//        solution3();
        solution5();
    }
}