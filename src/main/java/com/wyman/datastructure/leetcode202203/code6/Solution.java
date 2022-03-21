package com.wyman.datastructure.leetcode202203.code6;

import java.util.Arrays;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] resArr = new char[numRows][500];
        for (int i = 0; i < resArr.length; i++) {
            Arrays.fill(resArr[i], '-');
        }
        char[] chars = s.toCharArray();
        boolean flag = true;
        int row = 0, col = 0;
        for (int i = 0; i < chars.length; i++) {
            resArr[row][col] = chars[i];
            // 计算下一次位置
            if (flag) {
                row++;
                if (row == numRows) {
                    row -= 2;
                    col++;
                    flag = false;
                }
            } else {// 转折
                row--;
                col++;
                if (row == 0) {
                    flag = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resArr.length; i++) {
            for (int j = 0; j < resArr[i].length; j++) {
                if (resArr[i][j] != '-') {
                    sb.append(resArr[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        String convert = new Solution().convert(s, numRows);
        System.out.println(convert);
    }
}
