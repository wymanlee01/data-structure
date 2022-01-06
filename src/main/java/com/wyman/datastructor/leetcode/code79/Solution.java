package com.wyman.datastructor.leetcode.code79;

class Solution {
    public boolean exist(char[][] board, String word) {
        // 记录该点是否访问过
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        // 起始点位置
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 起始点位置和目标第一个字符匹配
                if (board[i][j] == chars[0]) {
                    // 从这里开始dfs,不行就从下一个点开始dfs
                    if (dfs(board, isVisited, i, j, chars, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] isVisited, int i, int j, char[] chars, int index) {
        // 说明找到匹配字符串
        if (chars.length == index) {
            return true;
        }
        // 触发上下边界
        if (i < 0 || i == board.length) {
            return false;
        }
        // 触发左右边界
        if (j < 0 || j == board[0].length) {
            return false;
        }
        // 已访问过
        if (isVisited[i][j]) {
            return false;
        }
        // 字符不匹配
        if (board[i][j] != chars[index]) {
            return false;
        }
        isVisited[i][j] = true;
        // 往下开始
        boolean dfs = dfs(board, isVisited, i + 1, j, chars, index + 1);
        // 不行就往上
        boolean dfs2 = dfs(board, isVisited, i - 1, j, chars, index + 1);
        // 往由
        boolean dfs3 = dfs(board, isVisited, i, j + 1, chars, index + 1);
        // 不行就往左
        boolean dfs4 = dfs(board, isVisited, i, j - 1, chars, index + 1);
        // 有个走通就可以
        if (dfs || dfs2 || dfs3 || dfs4) {
            return true;
        }
        isVisited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
        Solution solution = new Solution();
        boolean abcced = solution.exist(board, "ABCCED");
        System.out.println(abcced);

    }
}
