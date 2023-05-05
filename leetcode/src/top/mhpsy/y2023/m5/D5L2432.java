package top.mhpsy.y2023.m5;

public class D5L2432 {

}

class Solution2432 {
    public int hardestWorker(int n, int[][] logs) {
        int cur = logs[0][1];
        int id = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            if (logs[i][1] - logs[i - 1][1] > cur) {
                cur = logs[i][1] - logs[i - 1][1];
                id = logs[i][0];
            } else if (logs[i][1] - logs[i - 1][1] == cur && logs[i][0] < id) {
                id = logs[i][0];//id小的
            }
        }
        return id;
    }
}



