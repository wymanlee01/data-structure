package com.wyman.datastructure.leetcode202203.code728;

/**
 * 728. 自除数
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDividingNumbers(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isDividingNumbers(int i) {
        int c = i;
        while (c != 0) {
            int a = c % 10;
            if (a == 0) {
                return false;
            }
            if (i % a != 0) {
                return false;
            }
            c /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().selfDividingNumbers(47, 85);
        System.out.println(list);

    }
}
