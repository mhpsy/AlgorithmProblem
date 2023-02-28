package top.mhpsy.y2023.m2;

import java.util.Arrays;

public class D28LeetCode567 {
    public static void main(String[] args) {
        System.out.println(new Solution567B().checkInclusion("ab", "eidbaooo"));
        System.out.println(new Solution567C().checkInclusion("ab", "eidbaooo"));
        System.out.println(new Solution567D().checkInclusion("ab", "eidbaooo"));
    }
}

class Solution567D {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] need = new int[26];
        int[] window = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        for (int i = 0; i < len1; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(need, window)) return true;

        for (int i = len1; i < len2; i++) {//这里的i直接从len1开始
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - len1) - 'a']--;//减掉滑动出来的值,保持只有数组里面的值只存在s1的长度
            if (Arrays.equals(need, window)) return true;
        }
        /**
         * 滑动窗口
         * 总之就是保持一个窗口,窗口的大小是s1的长度,然后每次滑动一位,然后判断窗口里面的值是否和s1的值一样
         */
        return false;
    }
}

class Solution567C {
    public boolean checkInclusion(String s1, String s2) {
        //滑动窗口 直接复制的官方题解 我上面自己写一个Solution567D
        /**
         * 太妙了,真的太妙了
         * ctn1里面一直放着s1的各个字符出现的个数
         * ctn2里面一直放着s2里面窗口(跟s1长度相同的子串中)的各个字符出现的个数
         */
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];//窗口右移 也就是添加现在的子串的最后一个字符
            --cnt2[s2.charAt(i - n) - 'a'];//窗口右移 也就是删除子串的第一个字符
            //这两个操作就是在cnt2里面记录了窗口里面的各个字符出现的个数
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}


class Solution567B {
    public boolean checkInclusion(String s1, String s2) {
        /**
         * s1是子串
         * s2是母串
         * 判断s2中是否存在s1的排列
         */
        int slow = 0;
        int fast = 0;
        while (fast < s2.length() && slow < s1.length()) {
            if (s2.charAt(fast) != s1.charAt(slow)) {
                slow = 0;//如果不相等把slow慢指针置为0
            } else {
                slow++;//如果相等slow慢指针加一
            }
            fast++;
            if (slow == s1.length()) return true;//如果slow慢指针等于s1的长度说明存在相同的排列
        }
        return false;
    }
}


/**
 * 这是我2022.06.18写的 但是现在是2023年2月28日我已经看不懂了
 * 我得先看下这个我之前的想法
 */
class Solution567A {
    public boolean checkInclusion(String s1, String s2) {
        int sum = 0;
        for (char a : s1.toCharArray()) {
            sum += (int) a;//获取s1的ascii码和
        }

        int ansTest, index = 0, diff = 0;
        for (int i = 0; i < s2.length(); i++) {
            ansTest = 0;
            for (int j = i; j < i + s1.length() && j < s2.length(); j++) {
                ansTest += s2.charAt(j);
                index = j;
            }
            if (ansTest == sum) {
                String substring = s2.substring(index - s1.length() + 1, index + 1);
                for (int j = 0; j < s1.length(); j++) {
                    diff = substring.indexOf(s1.charAt(j));
                    if (diff < 0) break;
                }
                if (diff >= 0) {
                    return true;
                }
            }

        }

        return false;

    }
}
