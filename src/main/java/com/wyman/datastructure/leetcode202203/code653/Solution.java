package com.wyman.datastructure.leetcode202203.code653;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 两数之和 IV - 输入 BST
 */
class Solution {
  //  Map<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    Integer k;
    Boolean flag = false;

    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        pre(root);
        return flag;
    }

    public void pre(TreeNode node) {
        if (null == node) {
            return;
        }
        int sub = k - node.val;
       /* if (Integer.valueOf(1).equals(map.get(sub))) {
            flag = true;
        }
        map.put(node.val, 1);
        */
        if (set.contains(sub)) {
            flag = true;
        }
        set.add(node.val);
        pre(node.left);
        pre(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

