package com.wyman.datastructure.leetcode.code825;

import java.util.Arrays;

/**
 * 825. 适龄的朋友
 */
class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;

        int l = 0;
        int r = 0;
        int ans = 0;
        // 0.5*age[x]+7<age[y]<=age[x] 符合
        for (int i = 0; i < n; i++) {
            if (ages[i] < 15) {
                continue;
            }
            while (l < n && 0.5 * ages[l] + 7 < ages[i]) {
                l++;
            }
            while (r + 1 < n && ages[i] <= ages[r + 1]) {
                r++;
            }
            ans += (r - l);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] ages = {20, 30, 100, 110, 120};
        int i = new Solution().numFriendRequests(ages);
        System.out.println(i);
    }
}
