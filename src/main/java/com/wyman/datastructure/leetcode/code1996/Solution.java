package com.wyman.datastructure.leetcode.code1996;

import java.util.Arrays;

/**
 * 1996. 游戏中弱角色的数量
 */
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int ans = 0;
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        // 防御力最大
        int max = 0;
        for (int[] property : properties) {
            if (property[1] < max) {
                ans++;
            } else {
                max = property[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 5}, {10, 4}, {4, 3}};
        // arr = new int[][]{{5, 5}, {6, 3}, {3, 6}};
        System.out.println(new Solution().numberOfWeakCharacters(arr));
    }
}
