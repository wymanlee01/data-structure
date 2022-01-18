package com.wyman.datastructor.dfs;

import java.util.Stack;

/**
 * 数字排列组合
 *
 * @author liweiwen
 * @since 2022-01-16
 */
public class Combination {

    public Stack<Character> res = new Stack<>();

    public void dfs(char[] chars, boolean[] isVisit, int level) {
        if (level == 3) {
            System.out.println(res);
            return;
        }
        if (level > 3) {
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (isVisit[i]) {
                continue;
            }
            res.add(chars[i]);
            isVisit[i] = true;
            dfs(chars, isVisit, level + 1);
            isVisit[i] = false;
            res.pop();
        }
    }

    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C','D'};
        new Combination().dfs(chars, new boolean[10], 1);
    }

}
