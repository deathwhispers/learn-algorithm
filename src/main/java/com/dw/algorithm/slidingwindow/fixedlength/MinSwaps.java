package com.dw.algorithm.slidingwindow.fixedlength;

/**
 * 最少交换次数来组合所有的 1 II
 * 交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
 * <p>
 * 环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
 * <p>
 * 给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/2/17 9:16
 * <a href = "https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together-ii/description/">最少交换次数来组合所有的 1 II</a>
 */
public class MinSwaps {
    /**
     * 最小次数一定是窗口内 0 的次数的 最小值
     * 窗口大小就是数组中 1 的个数
     */
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int k = 0;
        // 统计窗口大小：窗口大小 = 数组中 1 的个数
        for (int num : nums) {
            k += num;
        }
        // 如果 k 为 0，则说明数组 nums 全部为 0，窗口长度为 0，返回 0
        if (k == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n + k; i++) {
            if (nums[i % n] == 0) {
                count++;
            }
            if (i < k - 1) {
                continue;
            }
            ans = Math.min(ans, count);
            if (nums[(i - k + 1) % n] == 0) {
                count--;
            }
        }
        return ans;
    }

}
