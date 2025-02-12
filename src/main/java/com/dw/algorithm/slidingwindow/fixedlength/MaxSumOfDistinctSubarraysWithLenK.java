package com.dw.algorithm.slidingwindow.fixedlength;

import java.util.HashMap;

/**
 * 长度为 K 子数组中的最大和
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/2/12 14:10
 * <a href= "https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/">长度为 K 子数组中的最大和</a>
 */
public class MaxSumOfDistinctSubarraysWithLenK {

    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        if (k > n) return ans;
        long sum = 0;
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 右侧元素进入窗口
            sum += nums[i];
            cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0) + 1);
            if (i < k - 1) continue;

            // 更新值，所有元素都不重复时（即 map 的元素个数等于 k ）
            if (cntMap.size() == k) {
                ans = Math.max(ans, sum);
            }

            // 左侧元素离开窗口
            int left = nums[i - k + 1];
            sum -= left;
            // 更新 map，若 map 中只有一个该元素，则删除 key，否则个数 -1
            Integer cnt = cntMap.get(left);
            if (cnt == 1) {
                cntMap.remove(left);
            } else {
                cntMap.put(left, cnt - 1);
            }
        }
        return ans;
    }
}
