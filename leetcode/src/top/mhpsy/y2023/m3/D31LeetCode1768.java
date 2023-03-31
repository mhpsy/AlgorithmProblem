package top.mhpsy.y2023.m3;

public class D31LeetCode1768 {
    public static void main(String[] args) {

    }
}

class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        int limitLen = Math.max(len1, len2);
        while (index < limitLen) {
            if (index < len1) stringBuilder.append(word1.charAt(index));
            if (index < len2) stringBuilder.append(word2.charAt(index));
            index++;
        }
        return stringBuilder.toString();
    }

    public String mergeAlternately2(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0, j = 0, m = word1.length(), n = word2.length();
        while (i < m || j < n) {
            if (i < m) stringBuilder.append(word1.charAt(i++));//i++直接写里面就行了
            if (j < n) stringBuilder.append(word2.charAt(j++));//i++直接写里面就行了
        }
        return stringBuilder.toString();
    }
}
