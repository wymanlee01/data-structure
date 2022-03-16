package com.wyman.datastructure.shotpath;

/**
 * 迪杰斯特拉算法
 *
 * https://houbb.github.io/2020/01/23/data-struct-learn-03-graph-dijkstra
 *
 * @author binbin.hou
 * @since 0.0.3
 */
public class DijkstraShortestPath {

    public int[] shortestPath(int[][] graph, int start) {
        // 数组构建
        final int length = graph.length;
        int[] shortestPathArray = new int[length];
        int[] visitedArray = new int[length];

        // 初始化
        // start==>start 路径长度为0
        shortestPathArray[start] = 0;
        // start 节点默认放在集合中
        visitedArray[start] = 1;

        // 开始循环处理剩下的节点
        for (int i = 1; i < length; i++) {
            // 距离 start 最近的点
            int k = -1;
            // 距离 start 最近的距离
            int disMin = Integer.MAX_VALUE;

            //1. 选取出距离顶点 start 最近的一个顶点
            for (int j = 1; j < length; j++) {
                // 元素不在已访问的列表中且距离顶点start最近
                if (visitedArray[j] == 0 && graph[start][j] < disMin) {
                    disMin = graph[start][j];
                    k = j;
                }
            }

            // 更新信息,加入到最短的集合
            visitedArray[k] = 1;
            shortestPathArray[k] = disMin;

            // 更新距离表
            for (int index = 1; index < length; index++) {
                //1. 不在最短列表中
                // 从源点v到S中各顶点的最短路径长度不大于从源点v到U中任何顶点的最短路径长度
                // graph[start][k] 起始点到k最短路径，graph[k][index] index++,k节点的邻接节点，
                // graph[start][index] 起始点直接到index节点的直接距离
                if (visitedArray[index] == 0
                        && graph[start][k] + graph[k][index] < graph[start][index]) {
                    graph[start][index] = graph[start][k] + graph[k][index];
                }
            }
        }

        return shortestPathArray;
    }

}
