package com.wyman.datastructure.leetcode.code747;

/**
 * 747. 至少是其他数字两倍的最大数
 */
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int aIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
                aIndex = i;
            } else if (nums[i] > b) {
                b = nums[i];
            }
        }

        return 2 * b <= a ? aIndex : -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 3, 2};
        int i = new Solution().dominantIndex(arr);
        System.out.println(i);
    }
}
