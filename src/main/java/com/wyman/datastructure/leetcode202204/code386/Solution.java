package com.wyman.datastructure.leetcode202204.code386;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 */
class Solution {
    private List<Integer> ans = new ArrayList<>();
    int limit;
    public List<Integer> lexicalOrder(int n) {
        this.limit = n;
        // 开头不能为0 单独处理
        for (int i = 1; i <= 9; i++) {
            dfs(i);
        }
        return ans;
    }

    private void dfs(int curr) {
        if (curr > limit) {
           return;
        }
        ans.add(curr);
        // 每个节点有0-9 10个数
        for (int i = 0; i <= 9; i++) {
            dfs(curr * 10 + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().lexicalOrder(13);
        System.out.println(list);
    }
}
