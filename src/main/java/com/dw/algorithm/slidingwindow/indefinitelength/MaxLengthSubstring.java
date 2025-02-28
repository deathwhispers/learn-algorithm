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

    /**
     * 1. 使用两个指针 left 和 right 来表示当前窗口的左右边界。
     * 2. 使用一个哈希表 count 来记录当前窗口中每个字符的出现次数。
     * 3. 移动 right 指针扩展窗口，并更新哈希表 count。
     * 4. 如果某个字符的出现次数超过2次，则移动 left 指针收缩窗口，直到所有字符的出现次数都不超过2次。
     * 5. 在每次调整窗口后，更新最大长度。
     */
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

    /**
     * 优化：
     * 用一个长度26的数组来记录每个字符出现的次数，来代替map
     * 将数组的下标和字符对应起来
     */
    public int maximumLengthSubstring2(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;
        int left = 0;
        // 存储每个字符出现的次数
        int[] cnt = new int[26];
        for (int right = 0; right < arr.length; right++) {
            // 右侧元素进入窗口
            char rightChar = s.charAt(right);
            int rightIdx = arr[right] - 'a';
            cnt[rightIdx]++;
            // 更新结果
            while (cnt[rightIdx] > 2) {
                int leftIdx = arr[left] - 'a';
                cnt[leftIdx]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            // 左侧元素出窗口
        }
        return ans;
    }

}
