package com.dw.algorithm.slidingwindow.indefinitelength;

/**
 * 1004. 最大连续1的个数 III
 *
 * 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
 */
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int count = 0;
        for (int right = 0; right < n; right++) {
            // 右侧元素进入窗口，若为 0 coung++
            if (nums[right] == 0) {
                count++;
            }
            if (count > k) {
                // 窗口左侧右移，若为 0 则 count--
                if (nums[left++] == 0) {
                    count--;
                }
            }
            // 更新结果
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
