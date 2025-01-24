package com.dw.algorithm.slidingwindow.fixedlength;

/**
 * 得到 K 个黑块的最少涂色次数
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/24 14:34
 * <a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/">得到 K 个黑块的最少涂色次数</a>
 */
public class MinimumRecolorsToGetKConsecutiveBlackBblocks {

    public int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();
        int n = arr.length;
        // 求最小值，将ans设为最大
        int ans = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            // 右侧元素进入窗口
            if (arr[i] == 'W') count++;
            if (i < k - 1) continue;
            // 更新结果
            ans = Math.min(count, ans);
            // 左侧元素离开窗口
            if (arr[i - k + 1] == 'W') count--;
        }
        return ans;
    }

}
