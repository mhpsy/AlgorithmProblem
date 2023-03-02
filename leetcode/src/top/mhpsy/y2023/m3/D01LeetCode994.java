package top.mhpsy.y2023.m3;

import java.util.LinkedList;
import java.util.Queue;

public class D01LeetCode994 {
    public static void main(String[] args) {
        System.out.println(new Solution994().orangesRotting(
                new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}
        ));

    }
}

class Solution994 {
    static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int xLen = grid.length;
        int yLen = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});//队列存放全部的坏橘子的位置
                }
            }
        }
        int x, y, len;
        while (!queue.isEmpty()) {
            len = queue.size();
            for (int j = 0; j < len; j++) {
                int[] cell = queue.poll();
                for (int i = 0; i < dirs.length; i++) {
                    x = cell[0] + dirs[i][0];
                    y = cell[1] + dirs[i][1];
                    if (!(x >= 0 && x < xLen && y >= 0 && y < yLen)) continue;
                    if (!(grid[x][y] == 1)) continue;
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
            if (!queue.isEmpty()) ans++;//这里是为了防止最后一次循环的时候ans++(因为最后一次循环的时候queue是空的
        }
        for (int[] ints : grid) {
            for (int j = 0; j < yLen; j++) if (ints[j] == 1) return -1;//说明依然存在正常的橘子
        }


        return ans;
    }
}

class Solution994A {
    static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int xLen = grid.length;
        int yLen = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});//队列存放全部的坏橘子的位置
                }
            }
        }
        int x, y;
        while (!queue.isEmpty()) {
            int size = queue.size();  // 记录当前层的节点数
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();//每一个int[]
                for (int j = 0; j < dirs.length; j++) {
                    x = cell[0] + dirs[j][0];
                    y = cell[1] + dirs[j][1];
                    if (x < 0 || x >= xLen || y < 0 || y >= yLen || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
            if (!queue.isEmpty()) {
                ans++;
            }
        }
        for (int[] ints : grid) {
            for (int j = 0; j < yLen; j++) if (ints[j] == 1) return -1;//说明依然存在正常的橘子
        }
        return ans;
    }

}

