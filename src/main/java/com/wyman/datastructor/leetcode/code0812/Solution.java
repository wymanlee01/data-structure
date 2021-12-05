package com.wyman.datastructor.leetcode.code0812;

import java.util.ArrayList;
import java.util.List;

/**
 * 八皇后
 * https://www.bilibili.com/video/BV1Yf4y1Q7kJ?from=search&seid=11413471665872339442&spm_id_from=333.337.0.0
 */
class Solution {

    /**
     * 记录当前已放置皇位置，arr[i] = j,表示第i行j列放置了皇后
     */
    int[] arr;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        arr = new int[n];
        check(n, 0);
        return result;
    }

    /**
     * @param n 棋盘大小
     * @param i 棋盘第i行
     */
    private void check(int n, int i) {
        if (n == i) {
            // 进入这里说明获得一种解,将当前棋盘放入结果集里
            List<String> list = new ArrayList<>();
            // 模拟遍历整个棋盘
            for (int x = 0; x < n; x++) {
                StringBuilder sb = new StringBuilder();
                for (int y = 0; y < n; y++) {
                    // 棋盘当前第x行y列匹配arr[x]=value,判断该位置是否有皇后
                    if (arr[x] == y) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
        } else {
            // 循环列,判断第i行j列可不可以放皇后
            for (int j = 0; j < n; j++) {
                // 第i行j列放皇后到arr数组
                arr[i] = j;
                if (judge(i)) {
                    // 第i行j列成功放皇后,开始下一行放置
                    check(n, i + 1);
                }
            }
        }
    }

    /**
     * 判断arr[index]=value, arr数组第index行value列位置皇后是否可以放置皇后，不与前面放置的皇后冲突
     *
     * @param index arr[index]=value, arr第index行value列位置皇后
     */
    private boolean judge(int index) {
        // 循环棋盘前index行
        for (int i = 0; i < index; i++) {
            // 同一列
            boolean columSame = arr[i]==arr[index];
            // 四角方向
            boolean fourDirection = Math.abs(index - i) == Math.abs(arr[index] - arr[i]);
            // 棋盘index行value列放置皇后冲突
            if (columSame || fourDirection) {
                return false;
            }
        }
        // 不在同一列且四角方向没皇后
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(8);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}