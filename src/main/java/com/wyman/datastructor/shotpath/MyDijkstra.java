package com.wyman.datastructor.shotpath;

/**
 * 迪杰斯特拉算法
 * https://houbb.github.io/2020/01/23/data-struct-learn-03-graph-dijkstra
 */
public class MyDijkstra {
    // 代表正无穷
    static final int M = 10000;
    // 二维数组每一行分别是 A、B、C、D、E 各点到其余点的距离,
    // A -> A 距离为0, 常量M 为正无穷
    static int[][] graph = {
            {0, 4, M, 2, M},
            {4, 0, 4, 1, M},
            {M, 4, 0, 1, 3},
            {2, 1, 1, 0, 7},
            {M, M, 3, 7, 0}
    };
    static int length = graph.length;
    // start到各个节点最短路径
    static int[] shortestPathArr = new int[length];
    // 记录标记节点
    static int[] visitedArr = new int[length];
    // 记录路径
    static String[] path = new String[length];

    public static void main(String[] args) {
        for (int i = 0; i < length; i++) {
            path[i] = 0 + "-->" + i;
        }
        int start = 0;
        shortestPath(graph, start);
        for (int i = 0; i < length; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短距离为：" + shortestPathArr[i]);
        }
        System.out.println("-----------------------");
        for (int i = 0; i < length; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短路径为：" + path[i]);
        }
    }

    private static void shortestPath(int[][] graph, int start) {
        // 初始化
        shortestPathArr[0] = 0;
        // start 节点默认已访问
        visitedArr[0] = 1;

        // 处理剩下节点
        for (int i = 1; i < length; i++) {
            // 距离start最近的点
            int k = -1;
            // 距离start最近的距离
            int disMin = Integer.MAX_VALUE;

            // 获取距离start最近的点,graph[start][j] start的邻接点
            for (int j = 1; j < length; j++) {
                if (visitedArr[j] == 0 && graph[start][j] < disMin) {
                    disMin = graph[start][j];
                    k = j;
                }
            }
            // 标记已访问节点，加入最短路径集合里
            visitedArr[k] = 1;
            shortestPathArr[k] = disMin;

            // 更新距离表，获取k节点的邻接点，
            // start 经过 k 到达 index 的距离小于start 直接到index 则修改
            for (int index = 0; index < length; index++) {
                if (visitedArr[index] == 0 && graph[start][k] + graph[k][index] < graph[start][index]) {
                    graph[start][index] = graph[start][k] + graph[k][index];
                    path[index] = path[k] + "-->" + index;
                }
            }
        }

    }
}
