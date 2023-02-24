package top.mhpsy.y2023.test;

public class divisionTest {
    public static void main(String[] args) {
        //a % b 的余数的定义是 (a/b)*b + a % b 恒等于 a
        System.out.println(14 % -3);
        System.out.println(-14 / 3);
        System.out.println(-14 % 3);
        System.out.println(14 / 3);
        System.out.println((14 / 3) * 3 + 14 % 3);
    }
}
