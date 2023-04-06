package top.mhpsy.y2023.m4;

public class D6LeetCode1480 {
    public static void main(String[] args) {

    }
}

class Solution1480 {
    /**
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = temp += nums[i];
        }
        return ans;
    }
}
