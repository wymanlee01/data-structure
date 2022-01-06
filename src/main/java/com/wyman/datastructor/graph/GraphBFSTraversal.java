package com.wyman.datastructor.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 图的广度优先遍历（BFS）
 */
public class GraphBFSTraversal {
    /**
     * 图
     */
    GraphDemo graph;
    /**
     * 是否被访问标志数组
     */
    boolean[] visited;

    /**
     * 初始化图，和访问标志数组
     */
    public GraphBFSTraversal(GraphDemo graph) {
        this.graph = graph;
        visited = new boolean[graph.graphs.size()];
    }


    public void BFS() {
        // 遍历每个节点
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]) {
                BSFTraversal(i);
            }
        }
    }

    private void BSFTraversal(int i) {
        // 队列存放需要遍历的节点
        Queue<Integer> queue = new ArrayDeque<>();
        visited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()) {
            // 当前节点
            Integer current = queue.poll();
            System.out.print(current + " -> ");
            // 获取当前节点的邻接节点
            for (Integer neighbor : graph.graphs.get(current)) {
                // 没有访问过
                if (!visited[neighbor]) {
                    // 设置已访问，并加入待遍历的队列中
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

}
