package com.wyman.datastructure.leetcode202204.code429;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 429. N 叉树的层序遍历  广度优先遍历
 */
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node poll = deque.poll();
                tempList.add(poll.val);
                deque.addAll(poll.children);
            }
            resList.add(tempList);
        }
        return resList;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node5.children = new ArrayList<>();
        node6.children = new ArrayList<>();
        node2.children = new ArrayList<>();
        node4.children = new ArrayList<>();

        List<Node> list3 = new ArrayList<>();
        list3.add(node5);
        list3.add(node6);

        List<Node> list1 = new ArrayList<>();
        list1.add(node3);
        list1.add(node2);
        list1.add(node1);
        node1.children = list1;
        node3.children = list3;

        List<List<Integer>> lists = new Solution().levelOrder(node1);
        System.out.println(lists);
    }

}


// Definition for a Node.
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
}

