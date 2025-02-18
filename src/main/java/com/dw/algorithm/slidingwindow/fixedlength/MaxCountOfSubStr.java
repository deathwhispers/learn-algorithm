package com.dw.algorithm.slidingwindow.fixedlength;

import java.util.Comparator;
import java.util.HashMap;

/**
 * 子串的最大出现次数
 * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 * <p>
 * 子串中不同字母的数目必须小于等于 maxLetters 。
 * 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/2/17 15:50
 * <a href="https://leetcode.cn/problems/maximum-number-of-occurrences-of-a-substring/description/">子串的最大出现次数</a>
 */
public class MaxCountOfSubStr {
    public static void main(String[] args) {
        MaxCountOfSubStr str = new MaxCountOfSubStr();
        int i = str.maxFreq("aababcaab", 2, 3, 4);
        System.out.println(i);
    }

    /**
     * 暴力解法：遍历每一个子串出现的次数，用 map 存储
     */
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int ans = 0;
        // map 用来存储每个子串出现的次数
        HashMap<String, Integer> map = new HashMap<>();
        // 子串长度 k 范围: minSize -> maxSize
        for (int k = minSize; k <= maxSize; k++) {
            StringBuilder subStr = new StringBuilder();
            // 记录子串中不同字母的个数
            HashMap<Character, Integer> letterMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                // 右侧元素进入窗口
                char right = arr[i];
                subStr.append(right);
                letterMap.put(right, letterMap.getOrDefault(right, 0) + 1);
                if (i < k - 1) {
                    continue;
                }
                // 不同字母的数目限制
                if (letterMap.size() <= maxLetters) {
                    // 更新答案
                    map.put(subStr.toString(), map.getOrDefault(subStr.toString(), 0) + 1);
                }

                // 左侧元素出窗口
                char left = arr[i - k + 1];
                subStr.deleteCharAt(0);
                Integer lcnt = letterMap.get(left);
                if (lcnt == 1) {
                    letterMap.remove(left);
                } else {
                    letterMap.put(left, lcnt - 1);
                }
            }
        }
        for (Integer value : map.values()) {
            ans = Math.max(ans, value);
        }
        return ans;
    }

    /**
     * 优化执行速度：
     * 1. 假设字符串T在给定的字符串S中出现的次数为k，那么T的任意一个子串出现的次数至少也为k，即T的任意一个子串在S中出现的次数不会少于T本身。
     * 这样我们就可以断定，在所有满足条件且出现次数最多的的字符串中，一定有一个的长度恰好为minSize。
     */
    public int maxFreq2(String s, int maxLetters, int minSize, int maxSize) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        // map 用来存储每个子串出现的次数
        HashMap<String, Integer> map = new HashMap<>();
        // 记录子串中不同字母的个数
        HashMap<Character, Integer> letterMap = new HashMap<>();
        // 子串长度 k 范围: minSize -> maxSize
        StringBuilder subStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 右侧元素进入窗口
            char right = arr[i];
            subStr.append(right);
            // 用 map 的 merge 方法可以提升执行速度
            letterMap.merge(right, 1, Integer::sum);
            if (i < minSize - 1) {
                continue;
            }
            // 不同字母的数目限制
            if (letterMap.size() <= maxLetters) {
                // 更新答案
                map.merge(subStr.toString(), 1, Integer::sum);
            }

            // 左侧元素出窗口
            char left = arr[i - minSize + 1];
            subStr.deleteCharAt(0);
            Integer count = letterMap.get(left);
            if (count == 1) {
                letterMap.remove(left);
            } else {
                letterMap.put(left, count - 1);
            }
        }
        return map.values().stream().max(Comparator.comparing(x -> x)).orElse(0);
    }
}
