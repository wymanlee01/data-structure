package com.wyman.datastructure.leetcode.code322;

/**
 * 322. 零钱兑换 DP
 */
class Solution3 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 存储0到amount每次金钱所需硬币最少数
        int[] moneys = new int[amount + 1];
        moneys[0] = 0;
        for (int currMoney = 1; currMoney <= amount; currMoney++) {
            // amount金钱硬币最少个数
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (currMoney - coins[j] >= 0 && moneys[currMoney-coins[j]] < min) {
                    min = moneys[currMoney - coins[j]] + 1;
                }
            }
            moneys[currMoney] = min;
        }
        return moneys[amount] == Integer.MAX_VALUE ? -1 : moneys[amount];
    }



    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int i = new Solution3().coinChange(coins, 11);
        System.out.println(i);
    }
}
