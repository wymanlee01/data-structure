package com.wyman.datastructure.leetcode.code475;

import java.util.Arrays;

/**
 * 475. 供暖器
 */
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int max = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            int j = 0, k = houses.length - 1;
            while (j < k) {
                if (houses[i] == heaters[j]) {
                    break;
                }
            }

        }
        return 0;
    }
}
