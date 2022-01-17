package com.wyman.datastructor.leetcode.code1220;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1220. 统计元音字母序列的数目
 */
class Solution {
    Stack<Character> stack = new Stack<>();
    Map<String, Integer> map = new HashMap<>();
    int count = 0;
    char[] chars = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelPermutation(int n) {
        dfs(n,  0);
        return count % 1000000007;
    }

    private void dfs(int n ,int level) {
        for (int j = 0; j < 5; j++) {
            if (level == n) {
                count++;
                System.out.println(stack);
                return;
            }
            boolean flag = false;
            if (!stack.isEmpty()) {
                if (stack.peek() == 'a' && chars[j] == 'e') {
                    flag = true;
                } else if (stack.peek() == 'e' && (chars[j] == 'a' || chars[j] == 'i')) {
                    flag = true;
                } else if (stack.peek() == 'i' && chars[j] != 'i') {
                    flag = true;
                } else if (stack.peek() == 'o' && (chars[j] == 'i' || chars[j] == 'u')) {
                    flag = true;
                } else if (stack.peek() == 'u' && chars[j] == 'a') {
                    flag = true;
                }
            } else {
                flag = true;
            }
            if (flag) {
                stack.push(chars[j]);
                dfs(n,  level + 1);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int i = new Solution().countVowelPermutation(144);
        System.out.println(i);
    }
}
