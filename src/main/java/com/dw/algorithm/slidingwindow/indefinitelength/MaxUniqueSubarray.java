package com.dw.algorithm.slidingwindow.indefinitelength;

import java.util.HashSet;

/**
 * 删除子数组的最大得分
 * <p>
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * </p>
 * <href = "">https://leetcode.cn/problems/maximum-erasure-value/description/</href>
 */
public class MaxUniqueSubarray {

    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int left = 0;
        int num = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            // 右侧元素进入窗口
            num += nums[right];

            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                num -= nums[left];
                left++;
            }
            set.add(nums[right]);

            ans = Math.max(ans, num);
        }
        return ans;
    }
}
