package top.mhpsy.y2023.m2;

import java.util.Arrays;

public class D28LeetCode733 {
    public static void main(String[] args) {
        int[][] ints = {{1, 2}, {2, 3}, {3, 4}};
        int[][] ints1 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(Arrays.deepToString(new Solution733().floodFill(ints, 1, 1, 2)));
    }
}

class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) dfs(image, sr, sc, newColor, oldColor);
        return image;
    }

    public void dfs(int[][] image, int x, int y, int newColor, int oldColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor) return;
        image[x][y] = newColor;
        dfs(image, x - 1, y, newColor, oldColor);
        dfs(image, x, y - 1, newColor, oldColor);
        dfs(image, x + 1, y, newColor, oldColor);
        dfs(image, x, y + 1, newColor, oldColor);
    }


}
