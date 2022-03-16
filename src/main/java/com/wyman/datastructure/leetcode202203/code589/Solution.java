package com.wyman.datastructure.leetcode202203.code589;

/**
 * 589. N 叉树的前序遍历
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            preorder(child);
        }
        return list;
    }

    public static void main(String[] args) {

    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
