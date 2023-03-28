package top.mhpsy.y2023.m3;

public class D27LeetCode1638 {
    public static void main(String[] args) {

    }
}

class Solution1638 {
    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = 0;
                for (int k = 0; i + k < m && j + k < n; k++) {
                    if (s.charAt(i + k) != t.charAt(j + k))
                        diff++;
                    if (diff == 1) {
                        ans++;
                    } else if (diff > 1) {
                        break;
                    }
                }

            }
        }
        return ans;
    }
}

