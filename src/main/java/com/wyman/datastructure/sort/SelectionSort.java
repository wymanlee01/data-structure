package com.wyman.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author liweiwen
 * @since 2021-11-26
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 7, 9, 5, 1, 4, 8};
        Arrays.sort(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
