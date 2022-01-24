package com.wyman.datastructor.leetcode.code322;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 322. 零钱兑换 记忆化搜索
 */
class Solution2 {
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        return dfs(coins, amount, 0);
    }

    /**
     * 找到amount最少count
     */
    private Integer dfs(int[] coins, int amount, int count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            Integer res = dfs(coins, amount - coins[i], count + 1);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        map.put(amount, min);
        return min;
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int i = new Solution2().coinChange(coins, 11);
        System.out.println(i);
    }
}
