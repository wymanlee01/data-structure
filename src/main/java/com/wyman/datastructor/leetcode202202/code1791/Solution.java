package com.wyman.datastructor.leetcode202202.code1791;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 1791. 找出星型图的中心节点
 */
class Solution {
    public int findCenter2(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.computeIfPresent(edges[i][0], (k, v) -> v + 1);
            map.putIfAbsent(edges[i][0], 1);
            map.computeIfPresent(edges[i][1], (k, v) -> v + 1);
            map.putIfAbsent(edges[i][1], 1);
        }
        Integer a = map.get(edges[0][0]);
        Integer b = map.get(edges[0][1]);
        if (a > b) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }

    public int findCenter3(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.compute(edges[i][0], (k, v) -> Objects.isNull(k) ? 1 : v + 1);
        }
        Integer a = map.get(edges[0][0]);
        Integer b = map.get(edges[0][1]);
        if (a > b) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];
        if (a == c || a == d) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {

    }
}
