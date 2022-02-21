package com.wyman.datastructor.leetcode202202.code540;

/**
 * 540. 有序数组中的单一元素
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        while (true) {
            if (end - start + 1 == 3) {
                if (nums[start + 1] == nums[start] && nums[end] != nums[start + 1]) {
                    return nums[end];
                } else {
                    return nums[start];
                }
            }
            int midIdx = (end + start) / 2;
            if ((end - midIdx) % 2 == 0) {
                start = midIdx;
            } else {
                end = midIdx;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3};//8 4 2,
        int[] arr2 = new int[]{1, 1, 3, 3, 4, 4, 8, 8, 9, 10, 10};//10 5 2
        int i = new Solution().singleNonDuplicate(arr2);
        System.out.println(i);
    }
}
