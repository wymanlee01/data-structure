package com.wyman.datastructor.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author liweiwen
 * @since 2021-11-05
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {16, 7, 3, 20, 17, 8};
        System.out.println("排序前" + Arrays.toString(arr));
        // 构建初始堆,从第一个非叶子节点开始调整，父节点大于左右子节点
        int startIndex = (arr.length - 1) / 2;
        for (int i = startIndex; i >= 0; i--) {
            heap(arr, arr.length, i);
        }
        // 排序,堆头元素与堆尾元素互换
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, i, 0);
        }
        System.out.println("排序后" + Arrays.toString(arr));
    }

    /**
     * 排序
     *
     * @param arr         待调整的堆
     * @param size        调整堆的范围
     * @param parentIndex 父节点
     */
    private static void heap(int[] arr, int size, int parentIndex) {
        int max = parentIndex;
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;
        // 左节点
        if (leftIndex < size && arr[leftIndex] > arr[max]) {
            max = leftIndex;
        }
        // 右节点
        if (rightIndex < size && arr[rightIndex] > arr[max]) {
            max = rightIndex;
        }
        // 交换位置
        if (max != parentIndex) {
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[max];
            arr[max] = temp;
            // 子节点也要调整
            heap(arr, size, max);
        }
    }
}
