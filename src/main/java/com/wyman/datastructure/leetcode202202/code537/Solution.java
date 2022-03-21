package com.wyman.datastructure.leetcode202202.code537;

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int index1 = num1.indexOf("+");
        Integer a = Integer.parseInt(num1.substring(0, index1));
        Integer b = Integer.parseInt(num1.substring(index1 + 1, num1.length() - 1));
        int index2 = num2.indexOf("+");
        Integer c = Integer.parseInt(num2.substring(0, index2));
        Integer d = Integer.parseInt(num2.substring(index2 + 1, num2.length() - 1));
        // (a+bi)(c+di)=(ac-bd)+(bc+ad)i
        Integer first = a * c - b * d;
        int second = (b * c + a * d);
        return first + "+" + second + "i";
    }

    public static void main(String[] args) {
        String num1 = "78+-76i";
        String num2 = "-86+72i";
        String s = new Solution().complexNumberMultiply(num1, num2);
        System.out.println(s);
    }
}
