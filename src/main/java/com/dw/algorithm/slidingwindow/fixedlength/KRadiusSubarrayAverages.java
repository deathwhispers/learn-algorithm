package com.dw.algorithm.slidingwindow.fixedlength;

import java.util.Arrays;

/**
 * 半径为 k 的子数组平均值
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/24 13:50
 * <a href="https://leetcode.cn/problems/k-radius-subarray-averages/description/">半径为 k 的子数组平均值</a>
 */
public class KRadiusSubarrayAverages {

    public static void main(String[] args) {
        KRadiusSubarrayAverages averages = new KRadiusSubarrayAverages();
        int[] nums = new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6};
        averages.getAverages(nums, 3);
    }

    public int[] getAverages(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length];
        long sum = 0;
        Arrays.fill(result, -1);
        if (2 * k > length) {
            return result;
        }
        for (int i = 0; i < 2 * k; i++) {
            sum += nums[i];
        }
        for (int i = k; i + k < length; i++) {
            sum += nums[i + k];
            result[i] = (int) (sum / (2 * k + 1));
            sum -= nums[i - k];
        }
        return result;
    }

    public int[] getAverages2(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length];
        long sum = 0;
        Arrays.fill(result, -1);
        for (int right = 0; right < length; right++) {
            // 右侧元素进入窗口
            sum += nums[right];
            // 窗口大小不足 2k+1
            if (right < 2 * k) {
                continue;
            }
            // 更新答案
            result[right - k] = (int) (sum / (2 * k + 1));
            // 左侧元素离开窗口
            sum -= nums[right - 2 * k];
        }
        return result;
    }

}
