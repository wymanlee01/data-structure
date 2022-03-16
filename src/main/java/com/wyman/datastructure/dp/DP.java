package com.wyman.datastructure.dp;

import java.util.Arrays;

/**
 * @author liweiwen
 * @since 2021-11-19
 */
public class DP {
    public static void main(String[] args) {
        // 各个物品重量
        int[] weight = {1, 4, 3};
        // 各个物品价值
        int[] value = {1500, 3000, 2000};
        // 背包最大容量
        int maxSize = 4;
        // 各种方法的价值的最大值
        int[][] maxValue = new int[value.length + 1][maxSize + 1];
        // 表示物品放入背包的方式
        int[][] method = new int[value.length + 1][maxSize + 1];

        for (int i = 1; i < maxValue.length; i++) {
            for (int j = 1; j < maxValue[0].length; j++) {
                // 物品重量大于背包剩余重量，不放入,最大价值还是上一个商品
                // 下标从1开始，所以要减1，从0开始
                if (weight[i - 1] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    // 剩余背包重量
                    int remaining = j - weight[i - 1];
                    // 如果放入该商品前的最大价值大于放入该物品后的最大价值
                    // maxValue[i - 1][remaining] 前i-1个商品在remaining容量下的最大价值
                    if (maxValue[i - 1][j] > value[i - 1] + maxValue[i - 1][remaining]) {
                        maxValue[i][j] = maxValue[i - 1][j];
                    } else {
                        maxValue[i][j] = value[i - 1] + maxValue[i - 1][remaining];
                        method[i][j] = 1;
                    }
                }
            }
        }

        // 打印背包最大价值数组
        for (int[] arr : maxValue) {
            System.out.println(Arrays.toString(arr));
        }

        // 打印最大价值的方案，即最大价值的方案
        int i = method.length - 1;
        int j = method[0].length - 1;
        while (i >= 0 && j >= 0) {
            if (method[i][j] == 1) {
                System.out.println("取出第" + i + "个商品");
                j = j - weight[i - 1];
            }
            i--;
        }


    }
}
