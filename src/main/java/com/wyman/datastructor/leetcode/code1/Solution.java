package com.wyman.datastructor.leetcode.code1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr ={3,2,4};
        int[] ints = new Solution().twoSum(arr, 6);
        System.out.println(ints);
    }
}
