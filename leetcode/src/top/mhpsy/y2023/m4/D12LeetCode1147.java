package top.mhpsy.y2023.m4;

public class D12LeetCode1147 {
    public static void main(String[] args) {
        String text = "ghiabcdefhelloadamhelloabcdefghi";
        System.out.println(new Solution1147().longestDecomposition(text));
    }
}

class Solution1147 {
    public int longestDecomposition(String text) {
        int ans = 0;

        char[] cs = text.toCharArray();
        int n = cs.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int len = 1;
            while (l + len <= r - len) {
                boolean flag = true;
                for (int i = 0; i < len; i++) {
                    if (cs[l] != cs[r]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans++;
                    l += len;
                    r -= len;
                    break;
                }
                len++;
            }
            if (l == r) {
                ans++;
                break;
            }
        }

        return ans;
    }

    public int longestDecomposition2(String text) {
        int n = text.length();
        int res = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            int len = 1;
            while (l + len - 1 < r - len + 1) {
                if (judge(text, l, r - len + 1, len)) {
                    res += 2;
                    break;
                }
                ++len;
            }
            if (l + len - 1 >= r - len + 1) {
                ++res;
            }
            l += len;
            r -= len;
        }
        return res;
    }

    public boolean judge(String text, int l1, int l2, int len) {
        while (len > 0) {
            if (text.charAt(l1) != text.charAt(l2)) {
                return false;
            }
            ++l1;
            ++l2;
            --len;
        }
        return true;

    }


}


