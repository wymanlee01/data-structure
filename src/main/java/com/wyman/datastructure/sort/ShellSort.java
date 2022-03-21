package com.wyman.datastructure.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author liweiwen
 * @since 2021-11-25
 */
public class ShellSort {
    public static void sort(int[] array) {
        // 希尔排序的增量
        int d = array.length;
        while (d > 1) {
            // 使用希尔增量的方式，即每次折半
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i = i + d) {
                    int temp = array[i];
                    int j = i - d;
                    while (j >= 0 && array[j] > temp) {
                        array[j + d] = array[j];
                        j = j - d;
                    }

                    array[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 6, 10, 2};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
