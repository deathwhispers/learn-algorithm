package com.dw.algorithm.slidingwindow.fixedlength;

/**
 * 子数组最大平均数 I
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/20 11:19
 * <a href = "https://leetcode.cn/problems/maximum-average-subarray-i/">子数组最大平均数 I</a>
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int sum = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            // 入：下标为 i 的元素进入窗口，更新统计量
            temp += nums[i];
            // 如果窗口长度不足，则继续
            if (i - 0 <= k - 1) {
                continue;
            }
            // 更新：更新结果值，最大值/最小值/平均值。。。
            sum = Math.max(sum, temp);
            // 出：窗口中 i-k+1 的元素离开，更新统计量
            temp -= nums[i - k + 1];
        }
        return (double) sum / k;
    }

}
