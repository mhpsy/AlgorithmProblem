package top.mhpsy.y2023.m2;

import java.util.*;

public class D28LeetCode2363 {
    public static void main(String[] args) {

    }
}

class Solution2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] v : items1) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }
        for (int[] v : items2) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            ArrayList<Integer> temporary = new ArrayList<>();
            temporary.add(k);
            temporary.add(v);
            ans.add(temporary);
        }
        ans.sort((x, y) -> x.get(0) - y.get(0));

        return ans;
    }
}
