package com.wyman.datastructure.unionFind;

import java.util.Arrays;

/**
 * 并查集
 *
 * @author liweiwen
 * @since 2021-11-23
 */
public class UnionFind {
    /**
     * 存储每个元素的父节点
     */
    public int[] parent;
    /**
     * 用户按秩合并，记录节点树深度
     */
    public int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            // 各个元素的父节点，默认自己
            parent[i] = i;
        }
        rank = new int[n];
        Arrays.fill(rank, 1);
    }

    /**
     * 查询元素的父节点
     */
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            // return find(parent[x]);
            // 路径压缩优化版
            int temp = find(parent[x]);
            parent[x] = temp;
            return temp;
        }
    }

    /**
     * 合并集合
     */
    public void merge(int x, int y) {
        // 找到x代表元素
        int i = find(x);
        // y的代表元素
        int j = find(y);
        // 同一个父节点
        if (i == j) {
            return;
        }
        // parent[i] = j;

        // 按秩合并优化,rank较小者往较大者上合并,和路径压缩一起用可以能会破环rank准确性
        if (rank[i] > rank[j]) {
            parent[j] = i;
        } else {
            // j的深度大于i
            parent[i] = j;
        }
        if (rank[i] == rank[j]) {
            rank[i]++;
        }
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(7);
        unionFind.merge(3, 1);
        unionFind.merge(2, 1);
        unionFind.merge(6, 4);
        unionFind.merge(5, 4);
        System.out.println(Arrays.toString(unionFind.parent));
    }
}
