package com.wyman.datastructure.leetcode202203.code440;

/**
 * 440. 字典序的第K小数字
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/shi-cha-shu-by-powcai/
 */
class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k -= 1;
        while (k > 0) {
            int count = stepCount(n, cur, cur + 1);
            if (count <= k) {
                k -= count;
                cur += 1;
            } else {
                // 先走第一步，向下走
                k -= 1;
                cur *= 10;
            }
        }

        return cur;
    }

    public int stepCount(int n, long n1, long n2) {
        int count = 0;

        while (n1 <= n) {
            count += Math.min(n - n1 + 1, (n2 - 1 - n1) + 1);
            n1 *= 10;
            n2 *= 10;
        }

        return count;
    }
}
