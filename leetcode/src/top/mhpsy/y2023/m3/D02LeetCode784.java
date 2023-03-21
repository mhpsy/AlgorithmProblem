package top.mhpsy.y2023.m3;

import java.util.ArrayList;
import java.util.List;

public class D02LeetCode784 {
    public static void main(String[] args) {
        String s = "a1b2";
        Solution784 solution784 = new Solution784();
        List<String> strings = solution784.letterCasePermutation(s);
        System.out.println(strings);
    }
}

//todo 自己写一个回溯的算法的，不难，
// 我现在的大概想法就是说如果是数字，
// 分一个分支，如果是字母，分两个分支，然后递归就好了

class Solution784 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        char[] charArray = S.toCharArray();
        dfs(charArray, 0, res);
        return res;
    }

    private void dfs(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }

        dfs(charArray, index + 1, res);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            dfs(charArray, index + 1, res);
        }
    }
}

class Solution784A {
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        backTracking(s.toCharArray(), 0);
        return ans;
    }

    public void backTracking(char[] chars, int index) {
        if (index == chars.length) {
            ans.add(new String(chars));
        }
        backTracking(chars, index + 1);
        if (Character.isLetter(chars[index])) {
            char oldChar = chars[index]; // 保存旧字符
            chars[index] ^= ' ';
            backTracking(chars, index + 1);
            chars[index] = oldChar; // 恢复旧字符，撤销修改
        }
    }
}

class Solution784B {
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        backTracking(s.toCharArray(), 0);
        return ans;
    }

    public void backTracking(char[] chars, int index) {
        if (index == chars.length) {
            ans.add(new String(chars));
            return;
        }
        backTracking(chars, index + 1);
        if (Character.isLetter(chars[index])) {
            chars[index] ^= ' ';//也就是相当于^=32 ^=1<<5 也就是+-32
//            如果字符是小写字符，减去 32 得到大写字符；
//            如果字符是大写字符，加上 32 得到小写字符。
//            而这两者合并起来，就是给这个字符做一次不进位的加法，即异或上 1 << 5
            backTracking(chars, index + 1);//改了大小写的还要再改回去进入回溯一次
            //也就是撤销修改
        }

    }
}
