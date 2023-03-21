package top.mhpsy.y2023.m3;

import java.util.Arrays;

public class D08LeetCode453 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        System.out.println(new Solution453().minMoves(ints));

    }
}

class Solution453 {
    public int minMoves(int[] nums) {
        int ans = 0;
        int minNum = Arrays.stream(nums).min().getAsInt();
        for (int num : nums) {
            ans += num = minNum;
        }
        return ans;
    }
}
