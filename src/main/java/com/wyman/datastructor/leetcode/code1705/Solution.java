package com.wyman.datastructor.leetcode.code1705;

import java.util.PriorityQueue;

/**
 * 1705. 吃苹果的最大数目
 */
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(6);
        priorityQueue.add(1);
        priorityQueue.add(0);
        priorityQueue.add(9);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

        return 0;
    }

    public static void main(String[] args) {
        new Solution().eatenApples(null, null);
    }
}
