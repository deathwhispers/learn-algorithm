package com.dw.algorithm.classicinterview;

/**
 * 存在重复元素 II
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/12/27 10:18
 * @see <a href="https://leetcode.cn/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150">存在重复元素 II</a>
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + k && j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
