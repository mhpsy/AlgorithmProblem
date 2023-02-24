package top.mhpsy.y2023.m2;

public class D22LeetCode189 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        new Solution190().rotate(nums, 3);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}

class Solution190 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k > len) return;
        int[] ans = new int[len];
        int index = 0;
        for (int i = (len - k); i < len; i++) {
            ans[index++] = nums[i];
        }

        int condition = index;
        for (int i = 0; i < (len - condition); i++) {
            ans[index++] = nums[i];
        }

        System.arraycopy(ans, 0, nums, 0, len);
    }
}