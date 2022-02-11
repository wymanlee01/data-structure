package com.wyman.datastructor.leetcode202202.code1984;

import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 */
class Solution {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            // 窗口内最大最小差值
            int sub = nums[i + k - 1] - nums[i];
            min = Math.min(min, sub);
        }
        return min;
    }


    public static void main(String[] args) {
        int i = new Solution().minimumDifference(new int[]{9, 4, 1, 7}, 2);
        System.out.println(i);
    }
}
