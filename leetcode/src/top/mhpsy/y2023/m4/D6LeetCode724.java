package top.mhpsy.y2023.m4;

import java.util.Arrays;

public class D6LeetCode724 {
    public static void main(String[] args) {
        System.out.println(new Solution724().pivotIndex1(new int[]{1, 7, 3, 6, 5, 6}));
    }
}

class Solution724 {
    public int pivotIndex(int[] nums) {
        int[] r = new int[nums.length];
        int[] l = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            l[i] = temp += nums[i];
        }

        temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            r[i] = temp += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (r[i] == l[i]) return i;
        }
        return -1;
    }


    public int pivotIndex1(int[] nums) {

        int[] sum = new int[nums.length + 1];//这里多加一个0，方便后面计算

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = temp += nums[i];
        }

        int total = sum[sum.length - 1];
        System.out.println(total);
        System.out.println(Arrays.toString(sum));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(sum[i] + " " + (total - sum[i + 1]));
            if (sum[i] == total - sum[i + 1]) return i;//这里要注意，sum[i]是左边的和，
            //total - sum[i + 1]是什么呢？就是右边的和，这里要注意，sum[i]是左边的和，
        }

        return -1;
    }
}
