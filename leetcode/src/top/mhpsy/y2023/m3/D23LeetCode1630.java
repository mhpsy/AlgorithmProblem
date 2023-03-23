package top.mhpsy.y2023.m3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class D23LeetCode1630 {
    public static void main(String[] args) {

    }
}

class Solution1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int[] subArray = IntStream.rangeClosed(l[i], r[i]).map(j -> nums[j]).toArray();
            //IntStream.rangeClosed的作用是生成一个闭区间的数字流，这里是生成一个从l[i]到r[i]的数字流
            //map的作用是对流中的每个元素进行操作，这里是对每个元素进行nums[j]的操作
            //toArray的作用是将流转换为数组
            //比如IntStream.rangeClosed(1,3).map(j->j*j).toArray()就是生成一个数组[1,4,9]
            ans.add(checkOneSubarrays(subArray));
        }


        return ans;
    }

    public boolean checkOneSubarrays(int[] nums) {
        int[] sort = Arrays.stream(nums).sorted().toArray();
        int subtract = 0;
        int len = sort.length;
        for (int i = 0; i < len - 1; i++) {
            if (i == 0) {
                subtract = sort[i + 1] - sort[i];
            } else {
                if (subtract != sort[i + 1] - sort[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
