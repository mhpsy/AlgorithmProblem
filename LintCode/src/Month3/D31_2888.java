package Month3;

import java.util.Arrays;
import java.util.HashSet;

public class D31_2888 {
    public static void main(String[] args) {

    }
}

class Solution {

    public int[] mergeArray(int arr1[], int arr2[]) {
        int[] ans = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        System.arraycopy(arr1, 0, ans, 0, arr1.length);
        System.arraycopy(arr2, 0, ans, arr1.length, arr2.length);
        return Arrays.stream(ans).sorted().distinct().toArray();
    }

    public int[] mergeArray2(int arr1[], int arr2[]) {
        HashSet<Integer> ans = new HashSet<>();
        for (int i : arr1) {
            ans.add(i);
        }
        for (int i : arr2) {
            ans.add(i);
        }
//        ans.stream().sorted().forEach(System.out::println);
        return ans.stream().mapToInt(Integer::valueOf).sorted().toArray();
    }
}
