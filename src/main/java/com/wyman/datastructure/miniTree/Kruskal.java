package com.wyman.datastructure.miniTree;

import com.wyman.datastructure.unionFind.UnionFind;

import java.util.*;

/**
 * https://blog.csdn.net/qq_43988642/article/details/108185702
 *
 * @author liweiwen
 * @since 2021-11-23
 */
public class Kruskal {

    /**
     * 连通图
     */
    private final List<Edge<String>> edgeList;
    /**
     * 结果集合
     */
    private final Set<Edge<String>> resultSet = new HashSet<>();
    /**
     * 总顶点数
     */
    private final int n;
    /**
     * 并查集
     */
    private final UnionFind unionFind;

    public Kruskal(List<Edge<String>> edgeList, int n) {
        this.edgeList = edgeList;
        this.n = n;
        this.unionFind = new UnionFind(n);
    }

    public static void main(String[] args) {
        List<Edge<String>> edgeList = new ArrayList<>();
        edgeList.add(new Edge<>("C", "D", 1));
        edgeList.add(new Edge<>("C", "A", 1));
        edgeList.add(new Edge<>("C", "E", 2));
        edgeList.add(new Edge<>("A", "B", 3));
        edgeList.add(new Edge<>("D", "E", 3));
        edgeList.add(new Edge<>("B", "C", 5));
        edgeList.add(new Edge<>("B", "E", 6));
        edgeList.add(new Edge<>("B", "D", 7));
        edgeList.add(new Edge<>("A", "D", 8));
        edgeList.add(new Edge<>("A", "E", 9));
        // 初始化数据
        Kruskal kruskal = new Kruskal(edgeList, 5);
        // 构建最小生成树
        kruskal.buildMST();
        // 遍历结果
        for (Edge<String> edge : kruskal.resultSet) {
            System.out.println(edge);
        }
    }

    /**
     * 构建最小生成树
     */
    private void buildMST() {
        // 边集排序
        Collections.sort(edgeList);
        // 遍历边集
        for (Edge<String> edge : edgeList) {
            if (!ok(edge)) {
                // 该边不能加入最小生成树中
                continue;
            }
            resultSet.add(edge);
            if (resultSet.size() == n - 1) {
                // 生成树的边数等于总顶点数-1，说明所有顶点已完成连接
                return;
            }
        }
    }

    /**
     * 判断该边是否可以加入
     */
    private boolean ok(Edge<String> edge) {
        char start = edge.getStart().charAt(0);
        char end = edge.getEnd().charAt(0);
        int x = unionFind.find(start - 'A');
        int y = unionFind.find(end - 'A');
        if (x != y) {
            // 起始点不在已选边集内，可以加入，合并该边，返回true
            unionFind.merge(x, y);
            return true;
        }
        return false;
    }

    /**
     * 边集的封装,边集可以用来表示图
     */
    static class Edge<T> implements Comparable<Edge<T>> {
        private T start;
        private T end;
        private int distance;

        public Edge(T start, T end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge targetEdge) {
            if (targetEdge.distance < distance) {
                return 1;
            }
            if (targetEdge.distance > distance) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return start + "->" + end + ":" + distance;
        }

        public T getStart() {
            return start;
        }

        public void setStart(T start) {
            this.start = start;
        }

        public T getEnd() {
            return end;
        }

        public void setEnd(T end) {
            this.end = end;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

    }
}
