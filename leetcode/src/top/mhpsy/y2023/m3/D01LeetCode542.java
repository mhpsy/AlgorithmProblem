package top.mhpsy.y2023.m3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D01LeetCode542 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution542().updateMatrix(
                new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}
        )));
    }
}

class Solution542 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});//每一个0的坐标 //offer添加队列尾部
                    seen[i][j] = true;//每一个0的坐标
                }
            }
        }

        while (!queue.isEmpty()) {//这里就是循环队列里面的每一个cell
            int[] cell = queue.poll();//移除并返回队列的头部元素,如果队列为空,返回null
            int i = cell[0], j = cell[1];
            for (int k = 0; k < dirs.length; k++) {
                int ni = i + dirs[k][0];//也就是依次获取cell里面保存位置的的上下左右
                int nj = j + dirs[k][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni, nj});//还需要把已经加1的坐标再次放入队列里面
                    seen[ni][nj] = true;
                }
            }
        }

        return dist;
    }
}
