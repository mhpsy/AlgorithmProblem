package top.mhpsy.y2023.m2;

public class D16T_MathSqrt {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(2));
        System.out.println(hypotenuse(3, 4));
    }

    public static double hypotenuse(double a, double b) {
        //计算直角三角形斜边长度
        return Math.sqrt(a * a + b * b);
    }
}
