package com.wyman.datastructor.leetcode.code2045;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 到达目的地的第二短时间
 */
class Solution {
    // 代表正无穷
    static final int M = 10000;
    // 二维数组每一行分别是 A、B、C、D、E 各点到其余点的距离,
    // A -> A 距离为0, 常量M 为正无穷
    static int[][] graph;
    static int length;
    // start到各个节点最短路径
    static int[] shortestPathArr;
    static int[] secondPathArr;
    // 记录标记节点
    static int[] visitedArr;
    // 记录路径
    static String[] path;

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        length= n+1;
        graph = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(graph[i], 10010);
        }
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]]  = time;
            graph[edge[1]][edge[0]]  = time;
        }
        // start到各个节点最短路径
        shortestPathArr = new int[length];
        // start到各个节点第二短路径
        secondPathArr = new int[length];
        // 记录标记节点
        visitedArr = new int[length];
        path = new String[length];

        int start = 1;
        shortestPath(graph, start);
        for (int i = 0; i < length; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短距离为：" + shortestPathArr[i]);
        }
        return -1;
    }

    private static void shortestPath(int[][] graph, int start) {
        // 初始化
        shortestPathArr[1] = 0;
        // start 节点默认已访问
        visitedArr[1] = 1;

        // 处理剩下节点
        for (int i = 2; i < length; i++) {
            // 距离start最近的点
            int k = -1;
            // 距离start最近的距离
            int disMin = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            // 获取距离start最近的点,graph[start][j] start的邻接点
            for (int j = 2; j < length; j++) {
                if (visitedArr[j] == 0 && graph[start][j] < disMin) {
                    secondMin = disMin;
                    disMin = graph[start][j];
                    k = j;
                } else if (visitedArr[j] == 0 && graph[start][j] > disMin) {

                }
            }
            // 标记已访问节点，加入最短路径集合里
            visitedArr[k] = 1;
            shortestPathArr[k] = disMin;

            // 更新距离表，获取k节点的邻接点，
            // start 经过 k 到达 index 的距离小于start 直接到index 则修改
            for (int index = 1; index < length; index++) {
                if (visitedArr[index] == 0 && graph[start][k] + graph[k][index] < graph[start][index]) {
                    graph[start][index] = graph[start][k] + graph[k][index];
                    path[index] = path[k] + "-->" + index;
                }
            }
        }

    }

    public static void main(String[] args) {
        int n = 5, time = 3, change = 5;
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        new Solution().secondMinimum(n, edges, time, change);
    }
}
