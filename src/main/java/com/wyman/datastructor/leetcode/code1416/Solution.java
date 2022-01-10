package com.wyman.datastructor.leetcode.code1416;

class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                count++;
            }
            if (')' == c) {
                count--;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        int i = new Solution().maxDepth(s);
        System.out.println(i);
    }
}
