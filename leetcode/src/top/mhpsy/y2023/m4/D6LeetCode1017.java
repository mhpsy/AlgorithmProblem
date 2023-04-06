package top.mhpsy.y2023.m4;

public class D6LeetCode1017 {
    public static void main(String[] args) {

    }
}

class Solution1017 {
    public String baseNeg2(int n) {
        //数字转负二进制

        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            stringBuilder.append(n & 1);
            n = -(n >> 1);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.reverse().toString();
    }
}
