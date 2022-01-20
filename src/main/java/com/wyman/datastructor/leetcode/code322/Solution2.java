package com.wyman.datastructor.leetcode.code322;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 322. 零钱兑换
 */
class Solution2 {
    Integer min = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    /**
     * 找到amount最少count
     */
    private Integer dfs(int[] coins, int amount, int count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
           return 1;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            Integer res = dfs(coins, amount - coins[i], count + 1);
            if (res >= 0 && res < min) {
                min = res;
            }
            map.put(amount, min);
        }

    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        new Solution2().coinChange(coins, 11);
    }
}
