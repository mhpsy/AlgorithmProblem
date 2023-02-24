package top.mhpsy.y2023.m2;

public class D22LeetCode977 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] ans = new Solution977().sortedSquares(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}

class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int[] ans = new int[len];
        /**
         这个双指针比较的好,那个从负数分开的指针很容易写错
         而且不用比较nums[l]和nums[r]的平方大小,直接比较-nums[l]和nums[r]的大小会好一些
         */
        for (int index = len - 1; l <= r; index--) {
            if (-nums[l] > nums[r]) {
                ans[index] = nums[l] * nums[l];
                l++;
            } else {
                ans[index] = nums[r] * nums[r];
                r--;
            }
        }

        return ans;
    }
}
