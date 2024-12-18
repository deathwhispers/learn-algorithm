package com.dw.algorithm.classicinterview;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/12/18 17:14
 * @see <a href="https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-interview-150">两数之和</a>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
