package com.wyman.datastructure.queue;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调递减队列
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 清理框外元素,队头
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }
            // 单调递减队列，删除窗口内比新入队元素小的旧元素
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            // 对尾添加元素
            deque.addLast(i);
            // 返回队头最大元素
            if (i >= k - 1) {
                res[resIndex++] = nums[deque.peekFirst()];
            }

        }
        return res;
    }

    /**
     * 使用优先队列
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) ->
                pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = new Solution().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));

    }
}
