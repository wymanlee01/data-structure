package com.wyman.datastructure.leetcode202202.code838;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 838. 推多米诺
 */
class Solution {
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        // 记录骨牌受力时间
        int[] g = new int[n];
        // 存储受力骨牌队列
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '.') {
                continue;
            }
            int dire = cs[i] == 'L' ? -1 : 1;
            d.add(new int[]{i, 1, dire});
            g[i] = 1;
        }
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int loc = info[0], time = info[1], dire = info[2];
            int ne = loc + dire;
            // 下一个多米诺越界情况
            if (cs[loc] == '.' || (ne < 0 || ne >= n)) {
                continue;
            }
            // 判断下一个多米诺第一次受力
            if (g[ne] == 0) {
                d.addLast(new int[]{ne, time + 1, dire});
                g[ne] = time + 1;
                cs[ne] = dire == -1 ? 'L' : 'R';
            } else if (g[ne] == time + 1) {
                cs[ne] = '.';
            }
        }
        return String.valueOf(cs);
    }
}
