package com.wyman.datastructor.leetcode.code322;

import java.util.Arrays;

/**
 * 322. 零钱兑换 DP
 */
class Solution4 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 存储0到amount每次金钱所需硬币最少数
        int[] moneys = new int[amount + 1];
        Arrays.fill(moneys, amount + 1);
        moneys[0] = 0;
        for (int currMoney = 1; currMoney <= amount; currMoney++) {
            for (int j = 0; j < coins.length; j++) {
                if (currMoney - coins[j] >= 0) {
                    // 当前硬币不选   选
                    moneys[currMoney] = Math.min(moneys[currMoney], moneys[currMoney - coins[j]] + 1);
                }
            }
        }
        return moneys[amount] == amount + 1 ? -1 : moneys[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int i = new Solution4().coinChange(coins, 11);
        System.out.println(i);
    }
}
