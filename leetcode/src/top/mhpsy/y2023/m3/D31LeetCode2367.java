package top.mhpsy.y2023.m3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class D31LeetCode2367 {
    public static void main(String[] args) {
        System.out.println(new Solution2367().arithmeticTriplets(new int[]{1, 2, 3, 4}, 1));

    }

}

class Solution2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int num : nums) {
            if (Arrays.stream(nums).anyMatch(v -> v == num + diff) && Arrays.stream(nums).anyMatch(v -> v == num + 2 * diff)) {
                count++;
            }
        }
        return count;
    }

    public int arithmeticTriplets2(int[] nums, int diff) {
        int ans = 0;
        HashSet<Integer> ints = new HashSet<>();
        for (int n : nums) {
            ints.add(n);
        }

        for (int num : ints) {
            if (ints.contains(num + diff) && ints.contains(num + diff * 2)) {
                ans++;
            }
        }

        return ans;
    }
}

