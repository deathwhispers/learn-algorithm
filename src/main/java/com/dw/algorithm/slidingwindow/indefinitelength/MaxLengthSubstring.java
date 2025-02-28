package com.dw.algorithm.slidingwindow.indefinitelength;

import java.util.HashMap;

/**
 * 每个字符最多出现两次的最长子字符串
 * <p>
 * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/2/28 14:12
 * <a href = "https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/">每个字符最多出现两次的最长子字符串</a>
 */
public class MaxLengthSubstring {

    public int maximumLengthSubstring(String s) {
        int ans = 0;
        // 存储每个字符出现的次数
        HashMap<Character, Integer> cntMap = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // 右侧元素进入窗口
            char rightChar = s.charAt(right);
            cntMap.merge(rightChar, 1, Integer::sum);

            // 更新结果
            while (cntMap.get(rightChar) > 2) {
                char leftChar = s.charAt(left);
                cntMap.put(leftChar, cntMap.get(leftChar) - 1);
                if (cntMap.get(leftChar) == 0) {
                    cntMap.remove(leftChar);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            // 左侧元素出窗口
        }
        return ans;
    }

}
