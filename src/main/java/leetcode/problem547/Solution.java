package leetcode.problem547;

import java.util.*;

public class Solution {
    class UnionFind {
        private int count;
        private Map<Integer,Integer> father;

        public UnionFind() {
            father = new HashMap<Integer,Integer>();
            count = 0;
        }

        public void add(int x) {
            if (!father.containsKey(x)){
                father.put(x, null);
            }
            count ++;
        }

        public void merge(int x, int y) {
            int x_root = find(x);
            int y_root = find(y);
            if(x_root != y_root) {
                count -- ;
                father.put(x_root, y_root);
            }
        }

        public int find(int x) {
            if (father.get(x) != null){
                return find(father.get(x));
            }
            return x;
        }

        public boolean isConnected(int x, int y) {
            if (find(x)==find(y)) return true;
            else return false;
        }
    }

    public int findCircleNum1(int[][] isConnected) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Set<Integer>> list = new ArrayList<>();
        UnionFind uf = new UnionFind();
        for(int i = 0; i <isConnected.length; i++){
            uf.add(i);
        }
        for (int i = 0; i < isConnected.length; i++){
            for (int j = i; j < isConnected[0].length; j++){
                if (isConnected[i][j] == 1){
                    uf.merge(i,j);
                }
            }
        }
        return uf.count;
    }
    int count;
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        count = n;
        for(int i = 0; i < isConnected.length; i++){
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++){
            for (int j = i; j < isConnected[0].length; j++){
                if (isConnected[i][j] == 1){
                    merge(i, j);
                }
            }
        }
        return count;
    }
    public void merge(int i, int j){
        int root_i = find(i);
        int root_j = find(j);
        if (root_j != root_i){
            parent[root_i] = root_j;
            count --;
        }
    }

    public int find1(int i){
        if (parent[i] != i){
            return find(parent[i]);
        }
        return i;
    }
    public int find(int x) {
        if (parent[x] == x) return x;
        int root = x;
        while (parent[root] != root){
            root = parent[root];
        }
        while (x != root){
            int next_x = parent[x];
            parent[x] = root;
            x = next_x;
        }
        return root;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(new Solution().findCircleNum(new int[][]{{1,1,1},{1,1,1},{1,1,1}}));
        System.out.println(new Solution().findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }
}
