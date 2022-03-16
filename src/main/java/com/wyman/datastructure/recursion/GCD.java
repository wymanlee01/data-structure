package com.wyman.datastructure.recursion;

/**
 * 最大公因数  辗转相除法
 *
 * @author liweiwen
 * @since 2022-02-22
 */
public class GCD {
    public static void main(String[] args) {
        int a = 8;
        int b = 6;
        System.out.println(gcd(a, b));
    }

    public static Integer gcd(int m, int n) {
        int rem = 0;
        while (n > 0) {
            rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

}
