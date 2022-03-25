package com.wyman.datastructure.leetcode202203.code172;

/**
 * 172. 阶乘后的零
 */
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        int f = f(n);
        System.out.println(f);
        while (f > 0) {
            if (f % 10 == 0) {
                res++;
            } else {
                return res;
            }
            f /= 10;
        }
        return res;
    }
    public int trailingZeroes2(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    private int f(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    public static void main(String[] args) {
        int i = new Solution().trailingZeroes(10);
        System.out.println(i);

    }
}
