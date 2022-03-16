package com.wyman.datastructure.leetcode;

/**
 * @author liweiwen
 * @since 2021-11-16
 */
public class Offer12 {
    private String pathStr;
    private String word;
    private Integer row;
    private Integer col;

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.word = word;
        return false;
    }

    public String find(char[][] board, int r, int c, String pathString) {
        return null;
    }
}
