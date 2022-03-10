package com.wyman.datastructor.leetcode202203.code2104;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public LinkedList<Integer> res = new LinkedList<>();
    int sum = 0;

    public long subArrayRanges(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            new Solution().dfs(nums, i + 1, 0);
        }
        return sum;
    }

    /**
     * @param chars  待选择的数
     * @param target 要选择多少个次
     * @param start  当前选择的是第几次
     */
    public void dfs(int[] chars, int target, int start) {
        if (res.size() == target) {
            if (res.size() > 1) {
                int sub = res.get(res.size() - 1) - res.get(0);
                sum = sum + sub;
                System.out.println();
                System.out.println(res);
                System.out.println("sum" + sum + " sub" + sub);
            }
            return;
        }
        for (int i = start; i < chars.length; i++) {
            res.add(chars[i]);
            // 这边从i开始，之前用过的就不使用了
            dfs(chars, target, i + 1);
            res.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        long l = new Solution().subArrayRanges(nums);
        System.out.println(l);
    }
}
