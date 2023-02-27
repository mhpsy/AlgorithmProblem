package top.mhpsy.y2023.m2;

public class funString {
    public static void main(String[] args) {
        String s = new String("123");
        f1(s);
        System.out.println(s);
        int[] ints = {1, 2, 3};

    }

    public static void f1(String str) {
        str += "123";
    }

    public static void f2(int[] arr) {
        arr[0]=22;
    }
}
