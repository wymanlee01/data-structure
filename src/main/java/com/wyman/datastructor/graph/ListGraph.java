package com.wyman.datastructor.graph;

import java.util.ArrayList;

/**
 * 图
 */
public class ListGraph {

    ArrayList<ArrayList<Integer>> graphs;

    public static void main(String[] args) {
        // 构建图
        ListGraph graph = new ListGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        // 打印邻接表
        graph.print();
        // 图的遍历
        GraphTraversal traversal = new GraphTraversal(graph);
        traversal.DFS();
       // traversal.BFS();

    }

    /**
     * 初始化构造图
     */
    public ListGraph(int v) {
        graphs = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graphs.add(new ArrayList<>());
        }
    }

    /**
     * 添加边
     */
    public void addEdge(int start, int end) {
        graphs.get(start).add(end);
    }

    /**
     * 移除边
     */
    public void removeEdge(int start, int end) {
        graphs.get(start).remove(end);
    }

    /**
     * 打印邻接表
     */
    public void print() {
        for (int i = 0; i < graphs.size(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < graphs.get(i).size(); j++) {
                System.out.print("->" + graphs.get(i).get(j));
            }
            System.out.println();
        }
    }
}
