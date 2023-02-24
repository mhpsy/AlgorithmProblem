package top.mhpsy.y2023.test;

public class toBinaryString {
    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        int num = 100;
        for (int i = num; i > 0; i /= 2) {
            res.insert(0, i % 2);
        }
        System.out.println(res);
    }
}
