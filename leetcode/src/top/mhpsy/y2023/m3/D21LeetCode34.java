package top.mhpsy.y2023.m3;

public class D21LeetCode34 {
    public static void main(String[] args) {
        int[] ints = {5, 7, 7, 8, 8, 10};
        int[] ints1 = new Solution34().searchRange(ints, 8);
        System.out.println(ints1[0] + " " + ints1[1]);

    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = left(nums, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = right(nums, target);
        return new int[]{left, right};
    }

    public int left(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }

        }
        return res;
    }


    public int right(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        int mid = l + ((r - l) >> 1);//
        while (l <= r) {
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                res = mid;
                l = mid + 1;
            }
            mid = l + ((r - l) >> 2);
        }
        return res;
    }
}
