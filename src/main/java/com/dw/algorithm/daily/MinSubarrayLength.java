package com.dw.algorithm.daily;

/**
 * 或值至少 K 的最短子数组 I
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/16 17:41
 * @see <a href="https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-i/">或值至少 K 的最短子数组 I</a>
 */
public class MinSubarrayLength {

    /**
     * 暴力枚举
     * i、j 从左往右，当满足 nums[i] -- nums[j] 或值大于 k 时，则找到了一个最小值
     * 遍历每一个起点位置，得出所有位置中的最小值。
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = i; j < n; j++) {
                value |= nums[j];
                if (value > k) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


}
