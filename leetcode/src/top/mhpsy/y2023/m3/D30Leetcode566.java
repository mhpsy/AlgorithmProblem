package top.mhpsy.y2023.m3;

public class D30Leetcode566 {
    public static void main(String[] args) {

    }
}

class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        //r行c列
        int[][] ans = new int[r][c];
        if (nums.length * nums[0].length != r * c) {
            return nums;//不符合要求所以直接返回原数组 可以看例子2就是这个意思
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int index = i * nums[i].length + j;//这里的index就是每一个元素在的位置(真实位置不关心数组维数,从0开始数的那种)
                ans[index / c][index % c] = nums[i][j];
            }
        }

        return ans;
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        //r行c列 m行n列
        int count = m * n;
        if (count != r * c) {
            return nums;//不符合要求所以直接返回原数组 可以看例子2就是这个意思
        }
        if (m == r && n == c) return nums;//如果行列数相等,直接返回原数组

        int[][] ans = new int[r][c];

        for (int i = 0; i < count; i++) {
            ans[i / c][i % c] = nums[i / n][i % n];
        }
        return ans;
    }

}


