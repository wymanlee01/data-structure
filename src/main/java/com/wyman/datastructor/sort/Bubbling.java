package com.wyman.datastructor.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author liweiwen
 * @since 2021-11-23
 */
public class Bubbling {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
