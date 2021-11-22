package com.wyman.datastructor.greedy;

/**
 * @author liweiwen
 * @since 2021-11-22
 */
public class FindCoin2 {
    static int x5 = 5, y2 = 4, z1 = 1;
    public static void main(String[] args) {
        int x = 5, y = 3, z = 1;
        pay(x, y, z, 30);
    }

    private static void pay(int x, int y, int z, int n) {
        if (n == 0) {
            System.out.println("刚好整");
            System.out.println("5块" + (x5 - x) + " 2块" + (y2 - y) + " 1块" + (z1 - z));
            return;
        } else if (n < 0) {
            return;
        }
        if (x > 0) {
            pay(x - 1, y, z, n - 5);
        }
        if (y > 0) {
            pay(x, y - 1, z, n - 2);
        }
        if (z > 0) {
            pay(x, y, z - 1, n - 1);
        }
    }
}
