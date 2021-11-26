package com.wyman.datastructor.sort;

import java.util.Arrays;

/**
 * 基数排序，桶排序
 * https://nyimac.gitee.io/2020/06/17/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B8%8E%E7%AE%97%E6%B3%95/#10%E3%80%81%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F
 *
 * @author liweiwen
 * @since 2021-11-26
 */
public class CardinalitySort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int len = arr.length;
        // 桶
        int[][] bucket = new int[10][len];
        // 记录每个桶实际装了多少元素
        int[] element = new int[10];
        // 最大元素的位数
        int maxIndex = getMaxIndex(arr);

        for (int i = 0, step = 1; i < maxIndex; i++) {
            step *= 10;
            for (int j = 0; j < len; j++) {
                int digits = arr[j] % step;
                // 放入对应桶中
                bucket[digits][element[digits]] = arr[j];
                // 桶元素加1
                element[digits]++;
            }
            // 原数组索引
            int index = 0;
            // 把桶元素返回数组里
            for (int j = 0; j < 10; j++) {
                // 桶元素索引
                int position = 0;
                if (element[j] > 0) {
                    // 将第j个桶里的第position元素放入原数组
                    arr[index] = bucket[j][position];
                    // 桶里元素索引+1
                    position++;
                    // 原数组索引+1
                    index++;
                    // 记录桶元素的数组个数-1
                    element[j]--;
                }
            }
        }
    }

    private static int getMaxIndex(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return String.valueOf(max).length();
    }

}
