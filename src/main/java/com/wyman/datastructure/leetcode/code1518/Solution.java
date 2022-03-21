package com.wyman.datastructure.leetcode.code1518;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        while (numBottles-numExchange>0) {
                    total++;
            numBottles-=numExchange;
            numBottles++;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numWaterBottles(15, 4);
        System.out.println(i);
    }
}
