package top.mhpsy.y2023.m2;

public class D24LeetCode557 {
    public static void main(String[] args) {
        System.out.println(new Solution557().reverseWords("Let's take LeetCode contest"));
    }

}

class Solution557 {
    public String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        for (String split : s.split(" ")) {
            char[] tempChars = split.toCharArray();
            for (int i = tempChars.length-1; i > 0; i--) {
                ans.append(tempChars[i]);
            }
            ans.append(" ");
        }
        return new String(ans.toString().toCharArray(),0,ans.toString().toCharArray().length-1);
    }
}

//class Solution557 {
//    public String reverseWords(String s) {
//        String[] split = s.split(" ");
//        for (int i = 0; i < split.length; i++) {
//            split[i] = new StringBuffer(split[i]).reverse().toString();
//        }
//        return String.join(" ", split);
//    }
//}

//class Solution557 {
//    public String reverseWords(String s) {
//        String[] splitString = s.split(" ");
//        for (int i = 0; i < splitString.length; i++) {
//            splitString[i] = reverseString(splitString[i]);
//            System.out.println(splitString[i]);
//        }
//        StringBuilder ans = new StringBuilder();
//        for (int i = 0; i < splitString.length; i++) {
//            if (i == splitString.length - 1) ans.append(splitString[i]);
//            else ans.append(splitString[i]).append(" ");
//        }
//        return ans.toString();
//    }
//
//    public String reverseString(String str) {
//        char[] s = str.toCharArray();
//        int l = 0, r = s.length - 1;
//        char temp;
//        while (l < r) {
//            temp = s[l];
//            s[l] = s[r];
//            s[r] = temp;
//            l++;
//            r--;
//        }
//        return new String(s);
//    }
//}
