package com.wyman.datastructor.leetcode202202.code917;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 仅仅反转字母
 */
class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0;
        int end = s.length() - 1;
        List<Character> list = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {
            list.add((char) i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            list.add((char) i);
        }
        char[] chars = s.toCharArray();
        while (start < end) {
            if (list.contains(chars[start]) && list.contains(chars[end])) {
                char t = chars[end];
                chars[end] = chars[start];
                chars[start] = t;
                start++;
                end--;
            } else {
                if (!list.contains(chars[start])) {
                    start++;
                }
                if (!list.contains(chars[end])) {
                    end--;
                }
            }
        }
        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        String s1 = new Solution().reverseOnlyLetters(s);
        System.out.println(s1);

        boolean a = Character.isLetter('a');

        byte[] arr = {50, 56, 68, -127, -120, -32, -128, 16};

        byte[] bytes1 = byte2Bit(arr);
        for (byte b : bytes1) {
            System.out.print(b);
        }

        String str = "0248";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println();
        System.out.println(bytes);

    }

    /**
     * 字节转成bit（字节数组表示）
     *
     * @param bytes
     * @return
     */
    public static byte[] byte2Bit(byte[] bytes) {
        int len = bytes.length;
        int bitLen = len * 8;
        byte[] bitArr = new byte[bitLen];
        for (int i = 0; i < len; i++) {
            byte b = bytes[i];
            bitArr[i * 8] = (byte) ((b >> 7) & 0x1);
            bitArr[i * 8 + 1] = (byte) ((b >> 6) & 0x1);
            bitArr[i * 8 + 2] = (byte) ((b >> 5) & 0x1);
            bitArr[i * 8 + 3] = (byte) ((b >> 4) & 0x1);
            bitArr[i * 8 + 4] = (byte) ((b >> 3) & 0x1);
            bitArr[i * 8 + 5] = (byte) ((b >> 2) & 0x1);
            bitArr[i * 8 + 6] = (byte) ((b >> 1) & 0x1);
            bitArr[i * 8 + 7] = (byte) ((b >> 0) & 0x1);
        }
        return bitArr;
    }

}
