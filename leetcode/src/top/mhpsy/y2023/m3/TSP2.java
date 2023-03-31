package top.mhpsy.y2023.m3;

import java.util.Arrays;

public class TSP2 {
    public static void main(String[] args) {
        double[][] distances = {
                {0, 1, 15, 6},
                {2, 0, 7, 3},
                {9, 6, 0, 12},
                {10, 4, 8, 0}
        };
        TSPSolver solver = new TSPSolver();
        solver.solve(distances);
        System.out.println("最优路径: " + Arrays.toString(solver.getBestTour()));
        System.out.println("最优路径长度: " + solver.getBestTourLength());

    }
}

class TSPSolver {
    private int[] bestTour;  // 存储最优解
    private double bestTourLength = Double.POSITIVE_INFINITY;  // 存储最优解的路径长度

    public void solve(double[][] distances) {
        int n = distances.length;
        int[] tour = new int[n];  // 存储当前路径
        for (int i = 0; i < n; i++) {
            tour[i] = i;
        }
        permute(tour, 0, distances);  // 开始回溯算法
    }

    /**
     * 回溯算法
     *
     * @param tour      当前路径
     * @param start     当前已经选择的节点数
     * @param distances 距离矩阵
     */
    private void permute(int[] tour, int start, double[][] distances) {
        int n = tour.length;
        if (start == n) {  // 找到了一种完整的路径
            double tourLength = calculateTourLength(tour, distances);
            if (tourLength < bestTourLength) {  // 如果这种路径更短，则更新最优路径
                bestTourLength = tourLength;
                bestTour = tour.clone();
            }
        } else {
            // 枚举所有可能的路径
            for (int i = start; i < n; i++) {
                swap(tour, start, i);
                permute(tour, start + 1, distances);
                swap(tour, start, i);
            }
        }
    }

    /**
     * 计算一条路径的长度
     *
     * @param tour      路径
     * @param distances 距离矩阵
     * @return 路径长度
     */
    private double calculateTourLength(int[] tour, double[][] distances) {
        double tourLength = 0;
        int n = tour.length;
        for (int i = 0; i < n - 1; i++) {
            tourLength += distances[tour[i]][tour[i + 1]];
        }
        tourLength += distances[tour[n - 1]][tour[0]];
        return tourLength;
    }

    /**
     * 交换数组中的两个元素
     *
     * @param arr 数组
     * @param i   索引1
     * @param j   索引2
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 获取最优路径
     *
     * @return 最优路径
     */
    public int[] getBestTour() {
        return bestTour;
    }

    /**
     * 获取最优路径长度
     *
     * @return 最优路径长度
     */
    public double getBestTourLength() {
        return bestTourLength;
    }
}
