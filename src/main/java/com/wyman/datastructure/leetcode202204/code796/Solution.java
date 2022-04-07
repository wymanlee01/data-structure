package com.wyman.datastructure.leetcode202204.code796;

/**
 * 796. 旋转字符串
 *
 * @author liweiwen
 * @since 2022-04-07
 */
class Solution {
    public boolean rotateString(String s, String goal) {
        int start = 0;
        StringBuilder sb = new StringBuilder(s);
        while (start < s.length() - 1) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if (goal.equals(sb.toString())) {
                return true;
            }
            start++;
        }
        return false;
    }

    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced";
        boolean b = new Solution().rotateString(s, goal);
        System.out.println(b);
    }
}
