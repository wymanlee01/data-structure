package com.wyman.datastructor.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 图的深度优先遍历（DFS）和广度优先遍历（BFS）
 */
public class GraphTraversal {
    /**
     * 图
     */
    ListGraph graph;
    /**
     * 是否被访问标志数组
     */
    boolean[] visited;

    /**
     * 初始化图，和访问标志数组
     */
    public GraphTraversal(ListGraph graph) {
        this.graph = graph;
        visited = new boolean[graph.graphs.size()];
    }

    public void DFS() {
        // 遍历每个节点
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]) {
                DFSTraversal(i);
            }
        }
    }

    private void DFSTraversal(int i) {
        // 访问过直接返回
        if (visited[i]) {
            return;
        }
        // 标记已被访问过
        visited[i] = true;
        System.out.print(i + " -> ");
        // 遍历邻接节点，再递归
        for (Integer neighbor : graph.graphs.get(i)) {
            if (!visited[neighbor]) {
                DFSTraversal(neighbor);
            }
        }
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
