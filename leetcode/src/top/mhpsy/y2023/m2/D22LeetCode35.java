package top.mhpsy.y2023.m2;

import java.sql.Array;
import java.util.Arrays;

public class D22LeetCode35 {
    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        System.out.println(solution35.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}



class Solution35 {

    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) return 0;
        else if (nums[nums.length - 1] < target) return nums.length;

        int l = 0, r = nums.length - 1;
        int mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;//如果nums[mid]<target 也就是说下一次的搜索区间必须是[mid+1,right]
            } else {
                r = mid;//如果nums[mid]>=target 也就是说下一次的搜索区间还是会包含mid的 也就是[left,mid]
                //因为这道题就是让找一个最小的大于等于target的下标;
            }
        }
        return l;
    }
//    public int searchInsert(int[] nums, int target) {
//        int l = 0, r = nums.length;
//        int mid = l + (r - l) / 2;
//
//        while (l < r) {
//            if (nums[mid] > target) {
//                r = mid - 1;
//            } else if (nums[mid] < target) {
//                l = mid + 1;
//            } else {
//                return mid;
//            }
//            mid = l + (r - l) / 2;
//        }
//        return l;
//    }
}
