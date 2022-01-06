package com.wyman.datastructor.graph;

/**
 * 图的深度优先遍历（DFS）
 */
public class GraphDFSTraversal {
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
    public GraphDFSTraversal(GraphDemo graph) {
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

}
