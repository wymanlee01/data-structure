package com.wyman.datastructor.leetcode.code322;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 322. 零钱兑换
 */
class Solution {
    Integer min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    Map<Integer, Stack<Integer>> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    private void dfs(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            if (count < min) {
                min = count;
                System.out.println(stack);
            }
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            stack.push(coins[i]);
            dfs(coins, amount - coins[i], count + 1);
            stack.pop();
        }

    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        new Solution().coinChange(coins, 11);
    }
}
