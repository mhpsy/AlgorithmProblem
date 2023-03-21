package top.mhpsy.y2023.m3;

import java.util.ArrayList;
import java.util.List;

public class D02LeetCode46 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        Solution46A solution46 = new Solution46A();
//        List<List<Integer>> permute = solution46.permute(nums);
//        System.out.println(permute);
        int[] nums = {1, 2, 3};
        Solution46B solution46 = new Solution46B();
        List<List<Integer>> permute = solution46.permute(nums);
        System.out.println(permute);
    }
}

class Solution46B { //这个是对的
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return ans;

        boolean[] used = new boolean[nums.length];
        backTracking(nums, nums.length, 0, used);
        return ans;
    }

    public void backTracking(int[] nums, int len, int depth, boolean[] used) {
//        if (temp.size() == len) {
//            ans.add(new ArrayList<>(temp));
//            return;
//        }
        // 在回溯算法中，depth参数表示当前已经选择了多少个元素。
        // 在排列问题中，我们需要选择n个元素，而每次选择一个元素，
        // 就将depth加1。当depth等于n时，就说明已经选择了n个元素，
        // 这个时候就得到了一个排列。
        // 因此，depth参数可以用来表示已经选择了多少个元素。
        if (depth == len) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;//如果已经加入过了就跳过
            temp.add(nums[i]);
            used[i] = true;
            backTracking(nums, len, depth + 1, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }

    }

}

class Solution46A { //这个是错误的
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return ans;
        backTracking(nums, nums.length, 0);
        return ans;
    }

    public void backTracking(int[] nums, int len, int startIndex) {
        if (temp.size() == len) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        int end = len;
        boolean flag = true;
        for (int i = startIndex; i < end; i++) {
            temp.add(nums[i]);
            System.out.println("temp = " + temp);
            if (i == end - 1 && startIndex != 0 && flag) {
                //如果i走到了最后一个，并且startIndex不是从0开始的那么就要在从0跑到startIndex
                flag = false;
                i = 0;
                end = startIndex;
            }
            backTracking(nums, len, startIndex + 1);
            temp.remove(temp.size() - 1);
        }

    }

}
