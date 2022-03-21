package com.wyman.datastructure.leetcode.code1345;

import java.util.*;

class Solution {

    /**
     * 是否被访问标志数组
     */
    boolean[] visited;
    int[] arr;
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public int minJumps(int[] arr) {
        // 存储相同数字下标
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        visited = new boolean[arr.length];
        this.arr = arr;
        return BFS();
    }

    private int BFS() {
        // 队列存放需要遍历的节点
        Queue<int[]> queue = new ArrayDeque<>();
        visited[0] = true;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            // 当前节点
            int[] current = queue.poll();
            int index = current[0];
            int step = current[1];
            if (index == arr.length - 1) {
                return step;
            }
            step++;
            // 向左没有访问过
            if (index + 1 < arr.length && !visited[index + 1]) {
                // 设置已访问，并加入待遍历的队列中
                visited[index + 1] = true;
                queue.add(new int[]{index + 1, step});
            }
            // 向右没有访问过
            if (index - 1 >= 0 && !visited[index - 1]) {
                // 设置已访问，并加入待遍历的队列中
                visited[index - 1] = true;
                queue.add(new int[]{index - 1, step});
            }
            // 相同元素
            if (map.containsKey(arr[index])) {
                for (int i : map.get(arr[index])) {
                    if (!visited[i]) {
                        // 到达最后一个元素
                        if (i == arr.length - 1) {
                            return step;
                        }
                        // 设置已访问，并加入待遍历的队列中
                        visited[i] = true;
                        queue.add(new int[]{i, step});
                    }
                }
                map.remove(arr[index]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int i = new Solution().minJumps(arr);
        System.out.println(i);
    }
}
