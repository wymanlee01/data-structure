package com.wyman.datastructor.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数字排列组合
 *
 * @author liweiwen
 * @since 2022-01-16
 */
public class DynamicCombination {

    public Stack<Character> res = new Stack<>();
    private List<List<Character>> list = new ArrayList<>();

    public void dfs(char[] chars, boolean[] isVisit, int n, int level) {
        if (level == n) {
            List<Character> objects = new ArrayList<>();
            int count =0;
            while (count < res.size()) {
                objects.add(res.peek());
                count++;
            }
            list.add(objects);
            return;
        }
        if (level > n) {
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (isVisit[i]) {
                continue;
            }
            res.add(chars[i]);
            isVisit[i] = true;
            dfs(chars, isVisit, n,level + 1);
            isVisit[i] = false;
            res.pop();
        }
    }

    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C','D'};
        new DynamicCombination()
                .dfs(chars, new boolean[10], 0, 1);

    }

}
