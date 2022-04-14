package com.wyman.datastructure.leetcode202204.code1672;

/**
 * 1672. 最富有客户的资产总量
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int t = 0;
            for (int j = 0; j < accounts[i].length;j++){
                t += accounts[i][j];
            }
            max = Math.max(max, t);
        }
        return max;
    }
}
