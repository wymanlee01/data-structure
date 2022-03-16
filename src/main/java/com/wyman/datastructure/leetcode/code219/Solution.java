package com.wyman.datastructure.leetcode.code219;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-1, -1};
        boolean b = new Solution().containsNearbyDuplicate(arr, 1);
        System.out.println(b);
    }
}
