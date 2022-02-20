package com.wyman.datastructor.leetcode202202.code717;

/**
 * 717. 1比特与2比特字符
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            int bit = bits[i];
            if (0 == bit) {
                if (i == bits.length - 1) {
                    return true;
                }
            } else {
                i++;
            }
        }
        return false;
    }

    public boolean isOneBitCharacter2(int[] bits) {
        int start = 0;
        while (start < bits.length - 1) {
            if (bits[start] == 0) {
                start++;
            } else {
                start += 2;
            }
        }
        return start == bits.length - 1;
    }
}
