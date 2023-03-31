package top.mhpsy.y2023.m3;

import java.util.*;

public class TSP {
    public static void main(String[] args) {
        int n = 5; // 城市数目
        int[][] distance = new int[n][n]; // 城市之间的距离矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = (int) (Math.random() * 100); // 随机生成距离
            }
        }
        List<Integer> tour = new ArrayList<>(); // 旅行路线
        boolean[] visited = new boolean[n]; // 是否已经访问过该城市
        int currentCity = 0; // 当前所在的城市
        tour.add(currentCity); // 将当前城市添加到旅行路线中
        visited[currentCity] = true; // 标记当前城市已经被访问
        for (int i = 1; i < n; i++) { // 需要访问剩下的n-1个城市
            int nextCity = findNearestCity(currentCity, visited, distance); // 找到下一个要访问的城市
            tour.add(nextCity); // 将该城市添加到旅行路线中
            visited[nextCity] = true; // 标记该城市已经被访问
            currentCity = nextCity; // 更新当前城市
        }
        System.out.println("旅行路线：" + tour.toString()); // 打印旅行路线
    }

    public static int findNearestCity(int currentCity, boolean[] visited, int[][] distance) {
        int n = visited.length;
        int minDistance = Integer.MAX_VALUE;
        int nearestCity = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && distance[currentCity][i] < minDistance) { // 如果该城市还没有被访问过且到该城市的距离更短
                minDistance = distance[currentCity][i];
                nearestCity = i;
            }
        }
        return nearestCity;
    }
}
