package leetcode.src.top.mhpsy.y2023.m5;

import java.util.Arrays;
import java.util.List;

public class D8Test {
    public static void main(String[] args) throws Exception {

        Class clazz = Class.forName("java.lang.ProcessBuilder");
        clazz.getMethod("start").invoke(clazz.getConstructor(List.class).newInstance(Arrays.asList("calc.exe")));

    }
}
