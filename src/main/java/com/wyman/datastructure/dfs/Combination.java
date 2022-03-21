package com.wyman.datastructure.dfs;

import java.util.LinkedList;

/**
 * @author liweiwen
 * @since 2022-02-22
 */
public class Combination {

    public LinkedList<Character> res = new LinkedList<>();

    /**
     * @param chars   待选择的数
     * @param target    要选择多少个次
     * @param start     当前选择的是第几次
     */
    public void dfs(char[] chars, int target, int start) {
        if (res.size() == target) {
            System.out.println(res);
            return;
        }
        for (int i = start; i < chars.length; i++) {
            res.add(chars[i]);
            // 这边从i开始，之前用过的就不使用了
            dfs(chars, target, i + 1);
            res.removeLast();
        }
    }

    public static void main(String[] args) {
        char[] chars = {'1', '2', '3', '4'};
        for (int i = 0; i < chars.length; i++) {
            new Combination().dfs(chars,  i + 1, 0);
        }
    }

}
