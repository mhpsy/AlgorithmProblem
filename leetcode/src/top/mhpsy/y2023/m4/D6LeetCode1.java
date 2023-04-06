package top.mhpsy.y2023.m4;

import java.util.Arrays;
import java.util.HashMap;

public class D6LeetCode1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().twoSum2Max(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10)));
        System.out.println(Arrays.toString(new Solution1().twoSum2Max(new int[]{3, 2, 4}, 6)));

    }
}

class Solution1 {

    /**
     * 最强的两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2Max(int[] nums, int target) {
        if (nums.length < 2) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1, left, right;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (l <= r) {
            //这里要注意，是<=，因为可以是三个数字的情况
            //比如{3, 2, 4}，target=6
            //这时候就是l=1，r=2，如果是l<r，那么就会跳出循环，所以这里是l<=r
            left = target - nums[l];
            right = target - nums[r];

            if (map.containsKey(left)) {
                return new int[]{map.get(left), l};
            } else {
                map.put(nums[l], l++);
            }

            if (map.containsKey(right)) {
                return new int[]{map.get(right), r};
            } else {
                map.put(nums[r], r--);
            }

        }

        return new int[]{-1, -1};
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
