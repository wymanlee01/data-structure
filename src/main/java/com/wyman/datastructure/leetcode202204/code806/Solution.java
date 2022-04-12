package com.wyman.datastructure.leetcode202204.code806;

import java.util.Arrays;

/**
 * 806. 写字符串需要的行数
 */
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int currWidth = 0;
        int line = 1;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 97;
            currWidth += widths[idx];
            if (currWidth > 100) {
                line++;
                currWidth = widths[idx];
            }
        }
        return new int[]{line, currWidth};
    }

    public static void main(String[] args) {
        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "bbbcccdddaaa";
        int[] ints = new Solution().numberOfLines(widths, s);
        System.out.println(Arrays.toString(ints));
    }
}
