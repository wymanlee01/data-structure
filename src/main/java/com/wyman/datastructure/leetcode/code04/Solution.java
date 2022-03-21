package com.wyman.datastructure.leetcode.code04;

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numLen1 = nums1.length;
        int numLen2 = nums2.length;
        int[] temp = new int[numLen1 + numLen2];
        int i = 0;
        int j = 0;
        int t = 0;
        while (i < numLen1 && j < numLen2) {
            if (nums1[i] <= nums2[j]) {
                temp[t++] = nums1[i++];
            } else {
                temp[t++] = nums2[j++];
            }
        }
        while (i < numLen1) {
            temp[t++] = nums1[i++];
        }
        while (j < numLen2) {
            temp[t++] = nums2[j++];
        }
        int midIndex = temp.length / 2;
        if (temp.length % 2 == 1) {
            return temp[midIndex];
        } else {
            return (temp[midIndex - 1] + (double) temp[midIndex]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);

    }
}
