package com.wyman.datastructure.leetcode.code539;

import java.util.*;

/**
 * 539. 最小时间差
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        List<Integer> minutePoints = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            minutePoints.add(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
        }
        Collections.sort(minutePoints);
        int min = Integer.MAX_VALUE;
        int size = minutePoints.size();
        for (int i = 0; i < size - 1; i++) {
            min = Math.min(min, minutePoints.get(i + 1) - minutePoints.get(i));
        }
        // 隔天情况
        int result = Math.min(min, minutePoints.get(0) + 1440 - minutePoints.get(size - 1));
        return result;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"23:59","00:00"};
        int minDifference = new Solution().findMinDifference(Arrays.asList(arr));
        System.out.println(minDifference);
    }
}
