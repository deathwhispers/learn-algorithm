package com.dw.algorithm.classicinterview;

/**
 * 最长公共前缀
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/10/21 15:10
 * @see <a href="https://leetcode.cn/problems/longest-common-prefix/?envType=study-plan-v2&envId=top-interview-150">最长公共前缀</a>
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
