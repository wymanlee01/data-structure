package com.wyman.datastructure.leetcode202202.code1447;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
               /* if (!isCom(i, j)) {
                    res.add(i + "/" + j);
                }*/
                BigInteger b1 = new BigInteger(i + "");
                BigInteger b2 = new BigInteger(j + "");
                BigInteger gcd = b1.gcd(b2);
                if (gcd.compareTo(new BigInteger(1 + "")) == 0) {
                    res.add(i + "/" + j);
                }
            }
        }
        return res;
    }

    public Boolean isCom(int a, int b) {
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<String> strings = new Solution().simplifiedFractions(4);
        System.out.println(strings);
        BigInteger b1 = new BigInteger("15");
        BigInteger b2 = new BigInteger("7");
        BigInteger gcd = b1.gcd(b2);
        System.out.println(gcd);
    }
}
