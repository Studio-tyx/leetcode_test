package leetcode.problem207;

import java.util.*;

public class Solution {
    public Map<Integer, List<Integer>> next_point = new HashMap<>();
    public int[] visited;
    public boolean valid = true;
    public void dfs(int node){
        visited[node] = 1;
        if(next_point.get(node)!=null) {
            for (int next : next_point.get(node)) {
                if (visited[next] == 0) {
                    dfs(next);
                } else if (visited[next] == 1) {
                    valid = false;
                    return;
                }
            }
        }
        visited[node] = 2;
        return;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        if(prerequisites.length == 0) return true;
        for (int[] prerequisite : prerequisites) {
            visited[prerequisite[0]] = 0;
            visited[prerequisite[1]] = 0;
            if (next_point.containsKey(prerequisite[0])) {
                next_point.get(prerequisite[0]).add(prerequisite[1]);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(prerequisite[1]);
                next_point.put(prerequisite[0], tmp);
            }
        }
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
        System.out.println(new Solution().canFinish(2, new int[][]{{0,1}}));
        System.out.println(new Solution().canFinish(2, new int[][]{{0,1},{1,0}}));
    }
}
