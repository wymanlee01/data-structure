package com.wyman.datastructor.leetcode.code743;

import java.util.Arrays;

class Solution {
    // 代表正无穷
    static final int M = 200;
    // 二维数组每一行分别是 A、B、C、D、E 各点到其余点的距离,
    // A -> A 距离为0, 常量M 为正无穷
    static int[][] graph;
    static int length;
    // start到各个节点最短路径
    static int[] shortestPathArr;
    // 记录标记节点
    static int[] visitedArr;


    public int networkDelayTime(int[][] times, int n, int k) {
        length = n+1;
        graph = new int[length][length];
        shortestPathArr = new int[length];
        visitedArr = new int[length];

        for (int i = 0; i < length; i++) {
            Arrays.fill(graph[i], M);
        }
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }
        shortestPath(graph, k);
        for (int i = 0; i < length; i++) {
            System.out.println("从" + k + "出发到" + i + "的最短距离为：" + shortestPathArr[i]);
        }
        int time = 0;
        for (int i : shortestPathArr) {
            if (i == M) {
                return -1;
            }
            if (i > time) {
                time = i;
            }
        }
        return time;
    }
    private static void shortestPath(int[][] graph, int start) {
        // 初始化
        shortestPathArr[start] = 0;
        // start 节点默认已访问
        visitedArr[start] = 1;

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
            for (int index = start; index < length; index++) {
                if (visitedArr[index] == 0 && graph[start][k] + graph[k][index] < graph[start][index]) {
                    graph[start][index] = graph[start][k] + graph[k][index];
                }
            }
        }

    }

    public static void main(String[] args) {
       // int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int[][] times = {{1, 2, 1}};
        int n = 2, k = 1;
        new Solution().networkDelayTime(times, n, k);
    }
}
