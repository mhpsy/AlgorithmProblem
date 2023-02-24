package top.mhpsy.y2023.m2;

import java.util.Arrays;
import java.util.HashSet;

public class D24LeetCode2357 {

}

class Solution2357 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int tempMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > tempMax) {
                tempMax = nums[i];
                ans++;
            }
        }
        return ans;
    }
}

//class Solution2357 {
//    public int minimumOperations(int[] nums) {
//        HashSet<Integer> ans = new HashSet<>();
//        for (int num : nums) {
//            if (num > 0) ans.add(num);
//        }
//        return ans.size();
//    }
//}