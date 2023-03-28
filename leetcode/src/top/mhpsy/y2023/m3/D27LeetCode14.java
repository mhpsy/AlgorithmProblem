package top.mhpsy.y2023.m3;

public class D27LeetCode14 {
    public static void main(String[] args) {
        System.out.println(new solution17().longestCommonPrefix(new String[]{"ab", "a"}));
    }
}

class solution17 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
//        String ans = "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < prefix.length() && j < strs[i].length(); j++) {
                //如果不相等，就截取前面的字符串
                //不能超过prefix的长度，也不能超过strs[i]的长度
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    //拿出来最大的子串
                    prefix = prefix.substring(0, j);
                    System.out.println("prefix = " + prefix);
                    break;
                }
            }
//            System.out.println("j = " + j);
        }
        return prefix;
    }
}
