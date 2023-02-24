package top.mhpsy.y2023.m2;

import java.util.ArrayList;
import java.util.List;

public class D22LeetCode1238 {
    public static void main(String[] args) {
        int n = 2;
        int start = 3;
        List<Integer> ans = new Solution1238().circularPermutation(n, start);
        for (int i : ans) {
//            System.out.print(i + " ");
        }
    }
}

class Solution1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        for (int i = start; i < 1 << n; i++) {
            System.out.println(i);
            ans.add(i * i >> 1);
        }
        return ans;
    }


    public List<Integer> circularPermutation2(int n, int start) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i ^ start);
        }
        return ret;
    }

}