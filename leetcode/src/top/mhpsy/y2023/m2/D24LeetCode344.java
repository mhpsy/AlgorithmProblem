package top.mhpsy.y2023.m2;

public class D24LeetCode344 {
    public static void main(String[] args) {
        Solution344 solution344 = new Solution344();
    }
}

class Solution344 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        char temp;
        while (l < r) {
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
