package com.wyman.datastructor.leetcode202203.code504;

/**
 * 10进制转7进制
 */
class Solution {
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    public static void main(String[] args) {
        String s = new Solution().convertToBase7(-7);
        System.out.println(s);
    }
}
