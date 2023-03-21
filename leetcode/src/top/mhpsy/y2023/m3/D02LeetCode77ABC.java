package top.mhpsy.y2023.m3;

import java.util.ArrayList;
import java.util.List;

public class D02LeetCode77ABC {
    public static void main(String[] args) {

    }
}

class Solution77ABC {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k || n <= 0 || k <= 0) return ans;
        backTracking(n, k, 1);
        return ans;
    }

    public void backTracking(int n, int k, int startIndex) {
        if (temp.size() == k) {
            ans.add(temp);
            return;
        }
        for (int i = startIndex; i < n; i++) {
            temp.add(i);
            backTracking(n, k, i + 1);
            temp.remove(temp.size() - 1);//删除最后一个元素 回溯
        }

    }
}