package true_test.huawei_0814;

import java.util.*;

public class Main {

    public boolean judgeScore(String x, double score){
        if(x.equals("A") && score >= 85) return true;
        else if (x.equals("B") && score < 85 && score >= 75) return true;
        else if (x.equals("C") && score < 75 && score >= 60) return true;
        else if (x.equals("D") && score < 60) return true;
        else return false;
    }
    public void problem_2(){
        Scanner in = new Scanner(System.in);
        String[] mxn = in.nextLine().split(" ");
        int m = Integer.parseInt(mxn[0]);
        String x = mxn[1];
        int n = Integer.parseInt(mxn[2]);
        Integer[] ids = new Integer[m];
        Map<Integer, String> names = new HashMap<>();
        Map<Integer, Double> scores = new HashMap<>();
        int count_n = 0;
        for(int i = 0; i < m; i++){
            String[] student = in.nextLine().split(" ");
            int id = Integer.parseInt(student[0]);
            String name = student[1];
            double score = Double.parseDouble(student[2]);
            if(judgeScore(x, score)) {
                names.put(id, name);
                scores.put(id, score);
                ids[count_n] = id;
                count_n ++;
            }
        }
        if(count_n == 0){
            System.out.println("[]");
            return;
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(scores.get(o1).equals(scores.get(o2))){
                    return -(o1.compareTo(o2));
                }
                else return (scores.get(o1).compareTo(scores.get(o2)));
            }
        };
        Arrays.sort(ids, 0, count_n, comparator);
        System.out.print("[");
        for(int i = 0; i < Math.min(n, count_n); i++){
            if(i != 0){
                System.out.print(", ");
            }
            System.out.print("[" + ids[i] + " "+ names.get(ids[i]) +"]");
        }
        System.out.println("]");
    }

    public boolean checkValid(int i, int j, int m, int n){
        if(i >= 0 && i < m && j >= 0 && j < n) return true;
        else return false;
    }
    public void problem_3_1(){
        Scanner in = new Scanner(System.in);
        int target_i = in.nextInt() - 1;
        int target_j = in.nextInt() - 1;
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = in.nextInt();
            }
        }
        List<int[]> current = new ArrayList<>();
        current.add(new int[]{target_i, target_j});
        List<int[]> end = new ArrayList<>();
        while(!current.isEmpty()){
            List<int[]> next = new ArrayList<>();
            for (int[] point : current) {
                if(grid[point[0]][point[1]] == 1){
                grid[point[0]][point[1]] = 3;
                boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
                if (checkValid(point[0] - 1, point[1], m, n) && grid[point[0] - 1][point[1]] == 1) {
                    next.add(new int[]{point[0] - 1, point[1]});
                    flag1 = true;
                }
                if (checkValid(point[0] + 1, point[1], m, n) && grid[point[0] + 1][point[1]] == 1) {
                    next.add(new int[]{point[0] + 1, point[1]});
                    flag2 = true;
                }
                if (checkValid(point[0], point[1] - 1, m, n) && grid[point[0]][point[1] - 1] == 1) {
                    next.add(new int[]{point[0], point[1] - 1});
                    flag3 = true;
                }
                if (checkValid(point[0], point[1] + 1, m, n) && grid[point[0]][point[1] + 1] == 1) {
                    next.add(new int[]{point[0], point[1] + 1});
                    flag4 = true;
                }
                if(!(flag1 && flag2 && flag3 && flag4)) end.add(point);
                }
            }
            current = next;
        }

        int count = 0;
        boolean flag = false;
        current = end;
        while (!current.isEmpty()){
            List<int[]> next = new ArrayList<>();
            for(int[] point : current){
                if(grid[point[0]][point[1]] == 1){
                    flag = true;
                    break;
                }
                if(grid[point[0]][point[1]] == 0) grid[point[0]][point[1]] = 3;
                if (checkValid(point[0] - 1, point[1], m, n) && grid[point[0] - 1][point[1]] != 3) {
                    next.add(new int[]{point[0] - 1, point[1]});
                }
                if (checkValid(point[0] + 1, point[1], m, n) && grid[point[0] + 1][point[1]] != 3) {
                    next.add(new int[]{point[0] + 1, point[1]});
                }
                if (checkValid(point[0], point[1] - 1, m, n) && grid[point[0]][point[1] - 1] != 3) {
                    next.add(new int[]{point[0], point[1] - 1});
                }
                if (checkValid(point[0], point[1] + 1, m, n) && grid[point[0]][point[1] + 1] != 3) {
                    next.add(new int[]{point[0], point[1] + 1});
                }
            }
            if(flag) break;
            current = next;
            count ++;
        }
        if(current.isEmpty()) System.out.println("-1");
        else System.out.println(count - 1);
    }

    public void problem_3_2(){
        Scanner in = new Scanner(System.in);
        int target_i = in.nextInt() - 1;
        int target_j = in.nextInt() - 1;
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = in.nextInt();
            }
        }
        List<int[]> current = new ArrayList<>();
        current.add(new int[]{target_i, target_j});
        Set<String> end = new HashSet<>();
        while(!current.isEmpty()){
            List<int[]> next = new ArrayList<>();
            for (int[] point : current) {
                if(grid[point[0]][point[1]] == 1){
                    grid[point[0]][point[1]] = 3;
                    boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
                    if (checkValid(point[0] - 1, point[1], m, n) && grid[point[0] - 1][point[1]] == 1) {
                        next.add(new int[]{point[0] - 1, point[1]});
                        flag1 = true;
                    }
                    if (checkValid(point[0] + 1, point[1], m, n) && grid[point[0] + 1][point[1]] == 1) {
                        next.add(new int[]{point[0] + 1, point[1]});
                        flag2 = true;
                    }
                    if (checkValid(point[0], point[1] - 1, m, n) && grid[point[0]][point[1] - 1] == 1) {
                        next.add(new int[]{point[0], point[1] - 1});
                        flag3 = true;
                    }
                    if (checkValid(point[0], point[1] + 1, m, n) && grid[point[0]][point[1] + 1] == 1) {
                        next.add(new int[]{point[0], point[1] + 1});
                        flag4 = true;
                    }
                    if(!(flag1 && flag2 && flag3 && flag4)) end.add(point[0] + "," + point[1]);
                }
            }
            current = next;
        }

        int count = 0;
        boolean flag = false;
        Set<String> current_blank = end;
        while (!current_blank.isEmpty()){
            Set<String> next = new HashSet<>();
            for(String point : current_blank){
                String[] points = point.split(",");
                int point_0 = Integer.parseInt(points[0]);
                int point_1 = Integer.parseInt(points[1]);
                if(grid[point_0][point_1] == 1){
                    flag = true;
                    break;
                }
                if(grid[point_0][point_1] == 0) grid[point_0][point_1] = 3;
                if (checkValid(point_0 - 1, point_1, m, n) && grid[point_0 - 1][point_1] != 3) {
                    next.add((point_0 - 1) +"," + point_1);
                }
                if (checkValid(point_0 + 1, point_1, m, n) && grid[point_0 + 1][point_1] != 3) {
                    next.add((point_0 + 1) +"," + point_1);
                }
                if (checkValid(point_0, point_1 - 1, m, n) && grid[point_0][point_1 - 1] != 3) {
                    next.add(point_0 +"," + (point_1 - 1));
                }
                if (checkValid(point_0, point_1 + 1, m, n) && grid[point_0][point_1 + 1] != 3) {
                    next.add(point_0 +"," + (point_1 + 1));
                }
            }
            if(flag) break;
            current_blank = next;
            count ++;
        }
        if(current_blank.isEmpty()) System.out.println("-1");
        else System.out.println(count - 1);
    }
    public void problem_1(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
//        List<int[]> nums = new ArrayList<>();
        Map<Integer, Integer> num_map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String[] cell_strs = in.nextLine().split(" ");
            String[] rsrp_strs = in.nextLine().split(" ");
            for(int j = 0; j < cell_strs.length; j++){
                int cell = Integer.parseInt(cell_strs[j]);
                int rsrp = Integer.parseInt(rsrp_strs[j]);
                if(num_map.containsKey(cell)){
                    num_map.put(cell, Math.max(num_map.get(cell), rsrp));
                }
                else{
                    num_map.put(cell, rsrp);
                }
            }
        }
        int[][] res = new int[num_map.size()][2];
        int count = 0;
        for(Integer key:num_map.keySet()){
            res[count][0] = key;
            res[count++][1] = num_map.get(key);
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        };
        Arrays.sort(res, comparator);
        for(int i = 0; i < count; i++){
            if(i != 0) System.out.print(" ");
            System.out.print(res[i][0]);
        }
    }
    public static void main(String[] args) {
        Main m = new Main();
//        m.problem_2();
//        m.problem_3_1();
        m.problem_3_2();
//        m.problem_1();
    }

}
