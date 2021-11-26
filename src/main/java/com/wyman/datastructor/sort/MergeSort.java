package com.wyman.datastructor.sort;

import java.util.Arrays;

/**
 * 归并排序
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 *
 * @author liweiwen
 * @since 2021-11-26
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 左边分
            sort(arr, left, mid, temp);
            // 右边分
            sort(arr, mid + 1, right, temp);
            // 治
            merge(arr, left, mid, right, temp);

        }
    }

    /**
     * 合并两个有序数组到temp数组
     * 再将temp数组复制回原数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}
