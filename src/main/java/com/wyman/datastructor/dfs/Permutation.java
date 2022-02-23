package com.wyman.datastructor.dfs;

import java.util.LinkedList;

/**
 * 数字排列, 和位置顺序有关 {A,B},{B,A} 两种排列
 *
 * @author liweiwen
 * @since 2022-01-16
 */
public class Permutation {

    public LinkedList<Character> res = new LinkedList<>();

    /**
     * @param chars   待选择的数
     * @param isVisit 已访问的元素
     * @param target  要选择多少个次
     * @param start     当前选择的是第几次
     */
    public void dfs(char[] chars, boolean[] isVisit, int target, int start) {
        if (res.size() == target) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (isVisit[i]) {
                continue;
            }
            res.add(chars[i]);
            isVisit[i] = true;
            dfs(chars, isVisit, target, start + 1);
            isVisit[i] = false;
            res.removeLast();
        }
    }

    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C', 'D'};
        for (int i = 0; i < chars.length; i++) {
            new Permutation().dfs(chars, new boolean[10], i + 1, 0);
        }
    }

}
