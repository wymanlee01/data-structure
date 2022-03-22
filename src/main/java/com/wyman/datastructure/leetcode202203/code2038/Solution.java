package com.wyman.datastructure.leetcode202203.code2038;

/**
 * 2038. 如果相邻两个颜色均相同则删除当前颜色
 */
class Solution {
    public boolean winnerOfGame(String colors) {
        char[] chars = colors.toCharArray();
        int sum = 0;
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i - 1] == 'A' && chars[i] == 'A' && chars[i + 1] == 'A') {
                sum++;
            }
            if (chars[i - 1] == 'B' && chars[i] == 'B' && chars[i + 1] == 'B') {
                sum--;
            }
        }
        return sum > 0;
    }

    public static void main(String[] args) {
        String colors = "AAAABBBB";
        boolean b = new Solution().winnerOfGame(colors);
        System.out.println(b);
    }
}
