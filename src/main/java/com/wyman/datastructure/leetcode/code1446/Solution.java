package com.wyman.datastructure.leetcode.code1446;

class Solution {
    public int maxPower(String s) {
        int ans = -1;
        int count = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 1;
            }
        }
        return Math.max(ans, count);
    }

}
