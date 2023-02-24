package top.mhpsy.y2023.m2;

public class D22LeetCode283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution283().moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        int j = 0, temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}