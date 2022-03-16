package com.wyman.datastructure.leetcode202202.code1994;

import java.util.*;

/**
 * 1994. 好子集的数目
 */
class Solution {
    public List<Integer> tempList = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public int numberOfGoodSubsets(int[] nums) {
        // 获取所有组合
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i + 1, 0);
        }
        System.out.println(res);
        // 互质组合
        Integer[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        Integer[] hes = {6, 10, 14, 15, 21, 22, 26, 30};
        List<Integer> primeNumber = Arrays.asList(prime);
        List<Integer> hesNumber = Arrays.asList(hes);

        res.removeIf(list -> !betweenPrimeNumber(list, primeNumber, hesNumber));
        System.out.println(res);
        return res.size() % 1000000007;
    }

    public void dfs(int[] nums, int target, int start) {
        if (tempList.size() == target) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(nums, target, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public boolean betweenPrimeNumber(List<Integer> nums, List<Integer> primeList, List<Integer> hesList) {
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{18,28,2,17,29,30,15,9,12};
        Solution solution = new Solution();
        int i = solution.numberOfGoodSubsets(arr);
        System.out.println(i);
    }
}
