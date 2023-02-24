package top.mhpsy.y2023.m2;

import java.lang.annotation.Target;
import java.util.Scanner;

public class D24LeetCode167 {
    public static void main(String[] args) {

//        while (true) {
//            int x = new Scanner(System.in).nextInt();
//            int y = new Scanner(System.in).nextInt();
//            if (x == 0) break;
//            System.out.println((x + y) / 2);
//            System.out.println(x + (y - x) / 2);
//            System.out.println(x + (y - x) >> 1);
//            System.out.println(x + (y - x) >>> 1);
//            System.out.println(x + ((y - x) >>> 1));
//        }

        for (int i : new Solution167().twoSum(new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8)) {
            System.out.print(i + " ");
        }
    }
}

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0, r = len - 1, mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (numbers[l] + numbers[mid] > target) {//左+中 大于 target 也就是说需要右边左移
                r = mid - 1;
            } else if (numbers[r] + numbers[mid] < target) {//右+中 小于 target 也就是说需要左边右移
                l = mid + 1;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }

        return new int[]{-1, -1};
    }
}

//class Solution167 {
//    public int[] twoSum(int[] numbers, int target) {
//        for (int l = 0, r = numbers.length - 1; l < r; ) {
//            if (numbers[l] + numbers[r] == target) {
//                return new int[]{l, r};
//            } else if (numbers[l] + numbers[r] > target) {
//                r--;
//            } else {
//                l++;
//            }
//        }
//        return new int[2];
//    }
//}
