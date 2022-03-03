package com.wyman.datastructor.leetcode202203.code258;

/**
 * 258. 各位相加
 */
class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int t = 0;
            while (num > 0) {
                t += (num % 10);
                num /= 10;
            }
            num = t;
        }
        return num;
    }

    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        int i = new Solution().addDigits(38);
        System.out.println(i);
    }
}
