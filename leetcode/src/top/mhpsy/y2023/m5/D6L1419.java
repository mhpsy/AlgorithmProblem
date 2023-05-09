package top.mhpsy.y2023.m5;

public class D6L1419 {
    public static void main(String[] args) {
        String croakOfFrogs = "ccroakroakcroak";
        System.out.println(new Solution1419B().minNumberOfFrogs(croakOfFrogs));
    }
}

class Solution1419 {
    // 数组比哈希表快。's' 保证 "croak" 中的任意字符都不会越界
    private static final char[] PREVIOUS = new char['s'];//因为最大的就是r所以s不会超出去 也就是长度为's'的一个数组

    static { // 预处理每个字母在 "croak" 中的上一个字母
        var s = "croakc".toCharArray();
        for (int i = 1; i < s.length; i++)
            PREVIOUS[s[i]] = s[i - 1];
        System.out.println(PREVIOUS);
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        var cnt = new int['s']; // 统计每个字母的数量
        for (var ch : croakOfFrogs.toCharArray()) {
            var pre = PREVIOUS[ch];
            if (cnt[pre] > 0) {
                cnt[pre]--;//前一个字母数量减一
            } else if (ch != 'c') {
                return -1;
            }
            cnt[ch]++; // 当前字母数量加一
        }
        if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0) {
            return -1;
        }
        return cnt['k'];
    }
}

class Solution1419B {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) return -1;
        //croakc
        int c, r, o, a, k;
        c = r = o = a = k = 0;
        char[] chars = croakOfFrogs.toCharArray();
        for (char ch : chars) {
            switch (ch) {
                case 'c' -> {
                    c++;
                    if (k > 0) k--;//如果有一个k就减去一个k
                }
                case 'r' -> {
                    r++;
                    c--;
                }
                case 'o' -> {
                    o++;
                    r--;
                }
                case 'a' -> {
                    a++;
                    o--;
                }
                case 'k' -> {
                    k++;
                    a--;
                }
            }
            if (c < 0 || r < 0 || o < 0 || a < 0) return -1;
            //如果有一个小于0就说明不对了 比如两个a连续一起 但是前面只有一个c 这样的话就直接把c减成负数了
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) return -1;//全部是0说明都被消耗了
//        System.out.println(c + " " + r + " " + o + " " + a + " " + k);
        return k;
    }

}
