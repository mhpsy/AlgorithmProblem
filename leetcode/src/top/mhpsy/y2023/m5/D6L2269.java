package leetcode.src.top.mhpsy.y2023.m5;

public class D6L2269 {
    public static void main(String[] args) {
        System.out.println(new Solution2269().divisorSubstrings(240, 2));

    }
}

class Solution2269 {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int ans = 0;
        for (int i = 0; i < s.length() - k + 1; i++) {
            int temp = Integer.parseInt(s.substring(i, i + k));
            if (temp == 0) continue;
            if (num % temp == 0) {
                ans++;
            }
        }
        return ans;
    }

    //去掉数字的第一位
    public int removeFirst(int num) {
        int ans = 0;
        int temp = 1;
        while (num > 0) {
            ans += num % 10 * temp;
            num /= 10;
            temp *= 10;
        }
        return ans;
    }
}
