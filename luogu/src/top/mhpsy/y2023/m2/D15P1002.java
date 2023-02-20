package top.mhpsy.y2023.m2;

import java.util.Scanner;

public class D15P1002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //一行四个正整数，分别表示B 点坐标和马的坐标。
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        k += 2;
        l += 2;
        m += 2;
        n += 2;

        //马可以走到的地方
        int[][] horseCanGo = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};

        long map[][] = new long[40][40];
        boolean visited[][] = new boolean[40][40];


        visited[k][l] = true;
        for (int i = 0; i < horseCanGo.length; i++) {
            visited[k + horseCanGo[i][0]][l + horseCanGo[i][1]] = true;
        }

        map[2][1] = 1;
        //因为全部加了2所以这里要从2开始的
        for (int i = 2; i < k; i++) {
            for (int j = 2; j < l; j++) {
                if (visited[i][j]) {
                    map[i][j] = 0;
                    continue;
                }
                System.out.println(map[i - 1][j]);
                System.out.println(map[i][j - 1]);
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        System.out.println(map[m][n]);
    }
}
