package com.wyman.datastructure.leetcode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 剑指 Offer 09. 用两个栈实现队列
 */
class CQueue {
    private Stack<Integer> helper = new Stack<>();
    private Stack<Integer> store = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        helper.clear();
        while (!store.isEmpty()) {
            helper.push(store.pop());
        }
        helper.push(value);
        while (!helper.isEmpty()) {
            store.push(helper.pop());
        }
    }

    public int deleteHead() {
        if (store.isEmpty()) {
            return -1;
        }
        return store.pop();
    }
}
