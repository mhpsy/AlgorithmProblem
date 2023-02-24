package top.mhpsy.y2023.m2;

import java.util.ArrayList;
import java.util.List;

public class D23LeetCode89 {
    public static void main(String[] args) {
        int n = 2;
        List<Integer> ans = new Solution89().grayCode(n);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}

class Solution89 {
    public List<Integer> grayCode(int n) {
        /**
         对于两个相邻的十进制数，对应的两个格雷码只有一个二进制位不同。另外，最大数与最小数间也仅有一个二进制位不同。
         我想了半天想不明白这是什么东西
         只能说公式就是G(i)=i^(i/2)
         主要就是知道公式就完事了
         */
        List<Integer> ans = new ArrayList<>();
        //题目说是2^n所以要用n<<1
        //不对应该是1<<n才对 这样的意思就是2^n
        for (int i = 0; i < (1 << n); i++)
            ans.add(i ^ i >> 1);
        return ans;

    }
}
