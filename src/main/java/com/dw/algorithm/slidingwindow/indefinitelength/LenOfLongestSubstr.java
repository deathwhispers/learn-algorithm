package com.dw.algorithm.slidingwindow.indefinitelength;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/2/27 14:27
 * <a href = "https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">无重复字符的最长子串</a>
 */
public class LenOfLongestSubstr {

    /**
     * 滑动窗口思路：
     * 1. 用一个 map 记录每个元素出现的位置
     * 2. 当发现重复元素时，将左指针指向该元素第一次出现位置 +1
     * 3. 更新该元素的位置
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        // map 保存每个字符的第一次出现位置
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < n) {
            // 右侧元素进入窗口
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                // 窗口中包含该元素,left移到right元素第一次出现的地方 +1
                left = map.get(rightChar) + 1;
            }
            map.put(rightChar, right);
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
