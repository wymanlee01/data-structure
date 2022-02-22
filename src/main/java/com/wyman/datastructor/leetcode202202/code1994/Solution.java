package com.wyman.datastructor.leetcode202202.code1994;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1994. 好子集的数目
 */
class Solution {
    public Stack<Integer> res = new Stack<>();
    private List<List<Integer>> list = new ArrayList<>();

    public int numberOfGoodSubsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, new boolean[10], i+1, 0);
        }
        return 0;
    }

    public void dfs(int[] chars, boolean[] isVisit, int n, int level) {
        if (level == n) {
            List<Integer> objects = new ArrayList<>();
            int count =0;
            while (count < res.size()) {
                objects.add(res.peek());
                count++;
            }
            list.add(objects);
            return;
        }
        if (level > n) {
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (isVisit[i]) {
                continue;
            }
            res.add(chars[i]);
            isVisit[i] = true;
            dfs(chars, isVisit, n, level + 1);
            isVisit[i] = false;
            res.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        Solution solution = new Solution();
        solution.numberOfGoodSubsets(arr);
        System.out.println(solution.list);
    }
}
