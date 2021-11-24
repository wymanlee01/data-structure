package com.wyman.datastructor.shotpath;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 佛洛依德算法
 * https://www.cnblogs.com/luoyoucode/p/12919601.html
 *
 * @author liweiwen
 * @since 2021-11-24
 */
public class MyFloyd {
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
    static int start = 0;
    static int[][] path = new int[graph.length][graph.length];

    public static void main(String[] args) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                path[i][j] = j;
            }
        }
        shortestPath();
        printShortDistance();
        printShortDistanceDetail();
    }

    private static void shortestPath() {
        for (int k = start; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
    }

    private static void printShortDistance() {
        for (int i = 0; i < graph.length; i++) {
            //for (int j = 0; j < graph.length; j++) {
            // System.out.println((char) (i + 65) + "到" + (char) (j + 65) + "最短路径为:" + graph[i][j]);
            System.out.println(Arrays.toString(graph[i]));
            // }
        }
    }

    private static void printShortDistanceDetail() {
        int k;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print("V" + i + "->V" + j + ", weight: " + graph[i][j] + ", path: " + i);
                k = path[i][j];
                while (k != j) {
                    System.out.print("->" + k);
                    k = path[k][j];
                }
                System.out.println();
            }

        }
    }


}
