package top.mhpsy.y2023.m3;

public class D02LeetCode198 {
    public static void main(String[] args) {

    }
}

class Solution198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        }

        return dp[dp.length - 1];
    }
}
