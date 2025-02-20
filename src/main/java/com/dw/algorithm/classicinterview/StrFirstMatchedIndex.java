package com.dw.algorithm.classicinterview;

/**
 * 找出字符串中第一个匹配项的下标
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/10/23 10:33
 * @see <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150">找出字符串中第一个匹配项的下标</a>
 */
public class StrFirstMatchedIndex {
    public int strStr(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) return i;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            int a = i, b = 0;
            while (b < m && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            if (b == m) {
                return i;
            }
        }
        return -1;
    }
}
