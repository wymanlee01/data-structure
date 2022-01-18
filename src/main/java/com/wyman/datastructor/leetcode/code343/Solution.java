package com.wyman.datastructor.leetcode.code343;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的K对数字
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        pq.add(2);
        pq.add(9);
        pq.add(3);
        pq.add(4);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().kSmallestPairs(null, null, 0);
    }
}

