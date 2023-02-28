package top.mhpsy.y2023.m2;

public class D28LeetCode695 {
    public static void main(String[] args) {
        System.out.println(new Solution695().maxAreaOfIsland(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}));

    }
}

class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int temp = dfs(grid, i, j);
                    ans = Math.max(temp, ans);
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) return 0;
        grid[x][y] = 2;
        return dfs(grid, x - 1, y) +
                dfs(grid, x + 1, y) +
                dfs(grid, x, y - 1) +
                dfs(grid, x, y + 1) + 1;//这里的1是因为自己算一个
    }
}