package com.wyman.datastructure.leetcode202204.code357;

/**
 * 357. 统计各位数字都不同的数字个数
 */
class Solution {
    /**
     * f[1] = 9 + f[0];
     * f[2] = 9 * 9 + f[1];
     * f[3] = 9 * 9 * 8 + f[2];
     * f[4] = 9 * 9 * 8 * 7 + f[3];
     */
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[10];
        // n=0 有1个数
        dp[0] = 1;
        int p = 9;
        for (int i = 1; i < 9; i++) {
            dp[i] = p + dp[i - 1];
            p = p * (9 - i + 1);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = new Solution().countNumbersWithUniqueDigits(3);
        System.out.println(i);
    }
}
