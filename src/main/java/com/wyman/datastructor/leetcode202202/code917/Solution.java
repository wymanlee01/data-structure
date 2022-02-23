package com.wyman.datastructor.leetcode202202.code917;

import java.util.ArrayList;
import java.util.List;

/**
 * 仅仅反转字母
 */
class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0;
        int end = s.length() - 1;
        List<Character> list = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {
            list.add((char) i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            list.add((char) i);
        }
        char[] chars = s.toCharArray();
        while (start < end) {
            if (list.contains(chars[start]) && list.contains(chars[end])) {
                char t = chars[end];
                chars[end] = chars[start];
                chars[start] = t;
                start++;
                end--;
            } else {
                if (!list.contains(chars[start])) {
                    start++;
                }
                if (!list.contains(chars[end])) {
                    end--;
                }
            }
        }
        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        String s1 = new Solution().reverseOnlyLetters(s);
        System.out.println(s1);

        boolean a = Character.isLetter('a');
    }
}
