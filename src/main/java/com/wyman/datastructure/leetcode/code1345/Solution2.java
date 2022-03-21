package com.wyman.datastructure.leetcode.code1345;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public int minJumps(int[] arr) {
        //本题可以理解为求无向图的最短路径问题 很容易就想到广度搜索 有三个方法可以选择
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        // 将相等的元素放入hashmap中
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        // int [] 存索引和步数
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        // 用于记录当前位置是否访问过
        boolean[] visit = new boolean[arr.length];
        visit[0] = true;
        // while循环
        while (!queue.isEmpty()) {
            // 出队
            int[] temp = queue.poll();
            int index = temp[0], step = temp[1];
            // 判断是否已经走到最后一个位置 ，如果是直接返回
            if (index == arr.length - 1)
                return step;
            // 向➡👉走
            step++;
            if (index + 1 < arr.length && !visit[index + 1]) {
                visit[index + 1] = true;
                queue.offer(new int[]{index + 1, step});
            }
            // 向⬅️走
            if (index - 1 >= 0 && !visit[index - 1]) {
                visit[index - 1] = true;
                queue.offer(new int[]{index - 1, step});
            }
            // 向相同元素的位置走
            if (map.get(arr[index]) != null) {
                for (int i : map.get(arr[index])) {
                    if (!visit[i]) {
                        if (i == arr.length - 1)
                            return step;
                        visit[i] = true;
                        queue.offer(new int[]{i, step});
                    }
                }
                map.remove(arr[index]);
            }
        }

        return -1;
    }
}

