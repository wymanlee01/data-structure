package com.wyman.datastructor.leetcode.code1688;

class Solution {
    public int numberOfMatches(int n) {
        int count = 0;
        int sum = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
                count = n;
            } else {
                count = (n - 1) / 2;
                n = count + 1;
            }
            sum += count;
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = new Solution().numberOfMatches(14);
        System.out.println(14);
    }
}
