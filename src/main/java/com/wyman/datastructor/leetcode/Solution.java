package com.wyman.datastructor.leetcode;


import java.util.*;

class Solution {
    private static Map<Integer, Integer> tempMap = new HashMap<>();

    public static int fib(int n) {
        Integer temp = tempMap.get(n);
        if (temp != null) {
            return temp;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result = fib(n - 1) + fib(n - 2);
        tempMap.put(n, result % 1000000007);
        return result % 1000000007;
    }

    public int numWays(int n) {
        return 0;

    }

    static int getWays2(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return temp % 1000000007;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[nums[i]] != nums[i]) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            if (nums[i] != i && nums[i] == nums[nums[i]]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        if (numbers[start] < numbers[end]) {
            return numbers[start];
        }
        int min = numbers[end];
        // 发生旋转,上一个元素会大于等于当前元素
        for (int i = end; i >= 0; i--) {
            if (!(min >= numbers[i])) {
                break;
            }
            min = numbers[i];
        }
        return min;
    }
    public boolean exist(char[][] board, String word) {

        return true;
    }
    public static void main(String[] args) {
        // int fib = fib(99);
        //int ways2 = getWays2(46);
        //  int[] arr = {2, 3, 1, 0, 2, 5, 3};
        //  int repeatNumber = findRepeatNumber(arr);
       /* int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean numberIn2DArray = findNumberIn2DArray(arr, 5);*/
        int[] arr = {3, 4, 5, 1, 2};
        int i = minArray(arr);
        System.out.println(i);
    }

}





