package com.wyman.datastructor.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author liweiwen
 * @since 2021-11-25
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 7, 9, 5, 1, 4, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        // 基数
        int base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            // 右边的数大于基数,小于就停下
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;
        // i==j 为中间基准数位置
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}
