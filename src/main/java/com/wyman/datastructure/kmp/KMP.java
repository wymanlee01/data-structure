package com.wyman.datastructure.kmp;

/**
 * @author liweiwen
 * @since 2021-11-19
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int result = getPosition(str1, str2);
        if (result != -1) {
            System.out.print("匹配位置是：str1[");
            System.out.println(result + "]");
        } else {
            System.out.println("匹配失败");
        }
    }

    /**
     * 通过kmp 算法匹配字符串
     *
     * @param raw  用于匹配的字符串
     * @param dest 要匹配的字符串
     * @return 第一个字符出现的位置，没有则返回-1
     */
    private static int getPosition(String raw, String dest) {
        // 获取dest 的部分匹配表
        int[] sectionTable = getTable(dest);
        // i:原字符串索引,j:已匹配字符个数
        for (int i = 0, j = 0; i < raw.length(); i++) {
            if (raw.charAt(i) == dest.charAt(j)) {
                j++;
                if (j == dest.length()) {
                    // 匹配完成，返回第一个字符出现位置
                    return i - dest.length() - 1;
                }
            } else {
                // 匹配失败，使用部分匹配表，跳转到对应位置
                // j==0,没有字符被匹配，直接往下走
                if (j == 0) {
                    continue;
                }
                 //跳转步数 = 已匹配个数- 部分匹配表对应的值
                int position = j - sectionTable[j - 1];
                i += position;
                // 循环后会+1 这里要减1
                i--;
                j = 0;
            }
        }
        return -1;
    }

    /**
     * 得到匹配字符串的部分匹配表
     *
     * @param dest 用于匹配的字符串
     * @return 部分匹配表
     */
    private static int[] getTable(String dest) {
        // 部分匹配数据
        int[] sectionTable = new int[dest.length()];
        // 匹配字符串的第一个元素没有前缀和后缀，部分匹配值为0
        sectionTable[0] = 0;
        // i用来指向部分匹配字符串末尾的字符，j用来指向开始的字符
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = sectionTable[j - 1];
            }
            if (dest.charAt(j) == dest.charAt(i)) {
                j++;
            }
            sectionTable[i] = j;
        }
        return sectionTable;
    }

}
