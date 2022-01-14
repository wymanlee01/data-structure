package com.wyman.datastructor.leetcode.code306;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean isAdditiveNumber(String num) {
        return dfs(0, num, new ArrayList<>(num.length()));
    }

    private boolean dfs(int index, String num, List<Long> pre) {
        int preLength = pre.size();
        int numLength = num.length();
        if (preLength >= 3 && pre.get(preLength - 1) != pre.get(preLength - 2) + pre.get(preLength - 3)) {
            return false;
        }
        if (index == numLength && preLength >= 3) {
            // 到结尾了, 且一直满足累加数规则
            return true;
        }
        for (int i = index; i < numLength; i++) {
            if (num.charAt(index) == '0' && i > index) {
                // 如果第一个是0且当前数长度不为, 那么则说明不是0而是0x, 不合理的数, 直接返回false即可
                break;
            }
            pre.add(substringTransferToLong(num, index, i));
            if (dfs(i + 1, num, pre)) {
                return true;
            }
            pre.remove(pre.size() - 1);
        }
        return false;
    }

    private long substringTransferToLong(String num, int start, int end) {
        long result = 0;
        for (int i = start; i <= end; i++) {
            result += (num.charAt(i) - '0');
            if (i != end) {
                result *= 10;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean additiveNumber = new Solution().isAdditiveNumber("199100199");
        System.out.println(additiveNumber);
    }

}
