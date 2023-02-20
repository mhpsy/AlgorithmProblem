package top.mhpsy.y2023.m2;

public class D18LeetCode5暴力 {
    public static void main(String[] args) {
        D18LeetCode5暴力Solution d18LeetCode5暴力Solution = new D18LeetCode5暴力Solution();
        System.out.println(d18LeetCode5暴力Solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

}

class D18LeetCode5暴力Solution {

    public String longestPalindrome(String s) {
        String res = "";
        int length = s.length();
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {//这里要加1 因为substring
                String test = s.substring(i, j);//每一个case
                if (isOk(test) && test.length() > max) {
                    res = test;
                    max = Math.max(max, res.length());
                }
            }

        }
        return res;
    }

    private boolean isOk(String s) {
//        System.out.println(s);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}