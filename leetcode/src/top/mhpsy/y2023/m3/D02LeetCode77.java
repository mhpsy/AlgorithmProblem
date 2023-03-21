package top.mhpsy.y2023.m3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class D02LeetCode77 {
    public static void main(String[] args) {
//        System.out.println(new Solution77().combine(4, 2));

        for (int i = 1; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                System.out.println(i + "  " + j);
            }
        }

    }
}


class Solution77 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                res.add(temp);
            }
        }
        return res;
    }

}
