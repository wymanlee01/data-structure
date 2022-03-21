package com.wyman.datastructure.leetcode202202.code1405;

import java.util.PriorityQueue;

/**
 * 1405. 最长快乐字符串
 */
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        // 按照数量构建堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) {
            queue.add(new int[]{0, a});
        }
        if (b > 0) {
            queue.add(new int[]{1, b});
        }
        if (c > 0) {
            queue.add(new int[]{2, c});
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            // 不能连续
            int n = sb.length();
            // 出现连续字符则从优先队列里找第二多数量的字符
            if (n >= 2 && sb.charAt(n - 1) - 'a' == curr[0] && sb.charAt(n - 2) - 'a' == curr[0]) {
                if (queue.isEmpty()) {
                    break;
                }
                int[] next = queue.poll();
                sb.append((char) (next[0] + 'a'));
                next[1]--;
                if (next[1] != 0) {
                    // 重新入堆
                    queue.add(next);
                }
                // 原来的元素也放回
                queue.add(curr);
            } else {
                sb.append((char) (curr[0] + 'a'));
                curr[1]--;
                if (curr[1] != 0) {
                    // 重新入堆
                    queue.add(curr);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().longestDiverseString(7, 1, 0);
        System.out.println(s);
    }
}
