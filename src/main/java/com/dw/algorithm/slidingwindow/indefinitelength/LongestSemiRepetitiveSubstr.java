package com.dw.algorithm.slidingwindow.indefinitelength;

/**
 * 2730. 找到最长的半重复子字符串
 * <p>
 * 给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。
 * 如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串 t 是 半重复的 。例如，"0010" 、"002020" 、"0123" 、"2002" 和 "54944" 是半重复字符串，而 "00101022" （相邻的相同数字对是 00 和 22）和 "1101234883" （相邻的相同数字对是 11 和 88）不是半重复字符串。
 * 请你返回 s 中最长 半重复 子字符串 的长度。
 * </p>
 *
 * <a href = "https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/description/">找到最长的半重复子字符串</a>
 */
public class EqualSubstring {

    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 0;
        int n = s.length();
        if (n < 2) return n;
        int left = 0;
        int cnt = 0;
        for (int right = 1; right < n; right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                cnt++;
            }
            while (cnt > 1) {
                if (s.charAt(left) == s.charAt(left + 1)) {
                    cnt--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
