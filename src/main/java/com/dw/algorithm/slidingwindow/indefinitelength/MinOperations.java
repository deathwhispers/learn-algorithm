package com.dw.algorithm.slidingwindow.indefinitelength;

/**
 * 1658. 将 x 减到 0 的最小操作数
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * <a href = "https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/">将 x 减到 0 的最小操作数</a>
 */
public class MinOperations {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0)
            return -1;
        int left = 0;
        int ans = -1;
        int sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left++];
            }
            if (sum == target) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans < 0 ? -1 : n - ans;
    }

}
