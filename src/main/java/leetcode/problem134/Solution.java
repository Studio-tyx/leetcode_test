package problem134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] delta = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            delta[i] = gas[i] - cost[i];
            sum += delta[i];
        }
        if (sum < 0) return -1;
        int front = 0;
        int back = 0;
        int part_sum = 0;
        while(front != (back - 1 + n) % n){
            if (front == back){
                if (delta[back] < 0){
                    back = (back + n + 1) % n;
                }
                else {
                    part_sum = delta[back];
                }
            }
            else {
                part_sum += delta[front];
                if (part_sum < 0){
                    back = front + 1;
                    part_sum = 0;
                }
            }
            front = (front + n + 1) % n;
        }
        return back;
    }
}
