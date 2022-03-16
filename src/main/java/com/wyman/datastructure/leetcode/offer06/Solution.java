package com.wyman.datastructure.leetcode.offer06;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int[] arr = new int[count];
        temp = head;
        for (int i = count - 1; i >= 0; i--) {
            arr[i] = temp.val;
            temp = temp.next;
        }
        return arr;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node1.next = node3;
        node3.next = node2;
        int[] ints = reversePrint(node1);
        System.out.println(Arrays.toString(ints));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
