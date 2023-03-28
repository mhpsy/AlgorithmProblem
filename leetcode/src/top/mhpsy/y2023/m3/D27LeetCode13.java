package top.mhpsy.y2023.m3;

public class D27LeetCode13 {
    public static void main(String[] args) {

    }
}

class Solution13 {
    public int romanToInt(String s) {
        int ans = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                ans -= preNum;
            } else {
                ans += preNum;
            }
            preNum = num;
        }
        ans += preNum;
        return ans;
    }

    public int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}
