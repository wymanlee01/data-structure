package com.wyman.datastructor.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author liweiwen
 * @since 2021-11-25
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 10, 2};
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j-1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
