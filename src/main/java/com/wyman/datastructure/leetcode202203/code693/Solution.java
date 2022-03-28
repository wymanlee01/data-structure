package com.wyman.datastructure.leetcode202203.code693;

import java.util.Arrays;

/**
 * 693. 交替位二进制数
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        System.out.println(Arrays.toString(chars));
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAlternatingBits2(int n) {
        // 保存上一次最后一位
        int cur = -1;
        while (n != 0) {
            // 取出最后一位
            int suf = n & 1;
            //  异或方式判断是否相同
            if ((cur ^ suf) == 0) {
                return false;
            }
            cur = suf;
            n = n >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean s = new Solution().hasAlternatingBits2(5);
        System.out.println(s);

    }
}
