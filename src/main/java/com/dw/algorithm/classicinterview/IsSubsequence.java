package com.dw.algorithm.classicinterview;

/**
 * 判断子序列
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/12/17 14:17
 * @see <a href="https://leetcode.cn/problems/is-subsequence/submissions/587605878/?envType=study-plan-v2&envId=top-interview-150">判断子序列</a>
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

}
