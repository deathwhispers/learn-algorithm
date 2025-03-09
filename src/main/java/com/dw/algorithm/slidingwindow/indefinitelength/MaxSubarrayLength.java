package com.dw.algorithm.slidingwindow.indefinitelength;

import java.util.HashMap;

/**
 * 最多 K 个重复元素的最长子数组
 * 给你一个整数数组 nums 和一个整数 k 。
 * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
 * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
 * 请你返回 nums 中 最长好 子数组的长度。
 * 子数组 指的是一个数组中一段连续非空的元素序列。
 */
public class MaxSubarrayLength {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            // 右侧元素进入窗口
            map.merge(nums[right], 1, Integer::sum);
            while (map.get(nums[right]) > k) {
                Integer count = map.get(nums[left]);
                if (count == 1) {
                    map.remove(nums[left]);
                } else {
                    map.merge(nums[left], -1, Integer::sum);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
