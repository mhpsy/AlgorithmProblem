package top.mhpsy.y2023.m3;

public class D23LeetCode1032 {
    public static void main(String[] args) {

    }
}

class StreamChecker {
    String[] words = null;
    StringBuilder sb = null;

    public StreamChecker(String[] words) {
        this.words = words;
        sb = new StringBuilder();
    }

    public boolean query(char letter) {
        StringBuilder append = sb.append(letter);
        String temp = append.toString();
        for (String word : words) {
            if (temp.endsWith(word)) {
                return true;
            }
        }
        return false;

    }
}
