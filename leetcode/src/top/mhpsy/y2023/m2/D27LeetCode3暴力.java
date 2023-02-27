package top.mhpsy.y2023.m2;

import java.util.HashMap;

public class D27LeetCode3暴力 {
    public static void main(String[] args) {
        System.out.println(new Solution3A().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution3B().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution3C().lengthOfLongestSubstring("abcabcbb"));
    }
}


class Solution3C {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        int start = 0;
        int index = s.length();
        int swap,ans=0;
        for(int i = 0; i<index;i++){
            swap = s.charAt(i);

            start = Math.max(start,arr[swap]);
            //如果swap之前也出现过，那么移动start的位置，
            //也就是移动到没有一个没有重复元素的位置
            //按照道理还说应该移动到arr[swap]里面值的下一个元素
            //但是因为直接存入的就是i+1所以直接让start取大的就好了

            //这行代码就是简单的选取最大值
            //加1的原因是因为有两个元素下标分别为[0,1] 1-0+1才会等于2
            ans = Math.max(ans,i-start+1);

            arr[swap]=i+1;
            //代表上一次出现的位置，
            //但是字符串内字符不能重复，
            //所以要从上一次出现位置的下一个位置开始
        }
        return ans;
    }
}

class Solution3B {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < len; r++) {//循环的时候要让r++
            char thisChar = s.charAt(r);//从右边取
            if (map.containsKey(thisChar)) {//遇到相同元素时
                l = Math.max(map.get(thisChar), l);//左边每次都选择当前值最大的下标,或者l本身
            }
            ans = Math.max(r - l + 1, ans);//r-l+1其实就是目前最长不重复的字符串长度
            map.put(thisChar, r + 1);//将thisChar和r+1放进去,+1是为了遇到重复字符串的时候从这个重复字符的下一个开始(l=这个+1)
        }
        return ans;
    }
}


class Solution3A {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            int tempAns = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) break;//思路根本不对,abcbb不重复的是5位其实不是的
                else tempAns++;
            }
            ans = Math.max(ans, tempAns);
        }
        return ans;
    }
}
