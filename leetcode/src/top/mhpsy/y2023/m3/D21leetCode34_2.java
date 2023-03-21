package top.mhpsy.y2023.m3;

public class D21leetCode34_2 {
    public static void main(String[] args) {

    }
}

class Solution34_2 {
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
        while (l <= r) {//l<=r
            mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;//因为是找左边界，所以要缩小右边界 也就是向左边移动一个位置 要找到最左边的target
            }
        }
        return res;
    }

    public int right(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        int mid;
        while (l <= r) {//l<=r
            mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                res = mid;
                l = mid + 1;//因为是找右边界，所以要缩小左边界 也就是向右边移动一个位置 要找到最右边的target
            }
        }
        return res;
    }
}