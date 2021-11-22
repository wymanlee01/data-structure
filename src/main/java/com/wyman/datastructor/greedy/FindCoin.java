package com.wyman.datastructor.greedy;

/**
 * @author liweiwen
 * @since 2021-11-22
 */
public class FindCoin {
    public static void main(String[] args) {
        int[] prices = {100, 50, 20, 10, 5, 1};
        int money = 123;
        splitChange(money, prices);
    }

    private static void splitChange(int money, int[] prices) {
        // 记录每种硬币个数
        int[] countArr = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            // 剩余金额必须大于等于硬币面值
            while (money - prices[i] >= 0) {
                money -= prices[i];
                // 硬币数加+1
                countArr[i] += 1;
            }
        }
        // 打印结果
        for (int i = 0; i < countArr.length; i++) {
            System.out.println("面值" + prices[i] + "个数" + countArr[i]);
        }
    }
}
