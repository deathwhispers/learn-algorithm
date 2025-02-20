package com.dw.algorithm.classicinterview;

/**
 * 最后一个单词的长度
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/10/17 10:47
 * @see <a href="https://leetcode.cn/problems/length-of-last-word/solutions/1008504/zui-hou-yi-ge-dan-ci-de-chang-du-by-leet-51ih/?envType=study-plan-v2&envId=top-interview-150">最后一个单词的长度</a>
 */
public class LengthOfLastWord {

    /**
     * string.split api
     */
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        int n = split.length;

        if (n > 0) {
            return split[n - 1].length();
        }
        return 0;
    }

    /**
     * 遍历
     */
    public int lengthOfLastWord2(String s) {
        int n = s.length();
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            // 处理最后为空格的情况，i+1不为 ' '
            if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                idx = i;
            }
        }
        int len = 0;
        for (int i = idx; i < n; i++) {
            if (s.charAt(i) != ' ') {
                len++;
            }
        }
        return len;
    }
}
