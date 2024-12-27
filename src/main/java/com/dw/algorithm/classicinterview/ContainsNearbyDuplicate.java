package com.dw.algorithm.classicinterview;

import java.util.HashSet;

/**
 * 存在重复元素 II
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/12/27 10:18
 * @see <a href="https://leetcode.cn/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150">存在重复元素 II</a>
 */
public class ContainsNearbyDuplicate {


    /**
     * 双指针，双层遍历
     */
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

    /**
     * 滑动窗口
     * 只需要判断滑动窗口中是否存在重复元素即可
     * 通过Set的元素不重复属性来实现
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) {
                // i > k 后，将最左侧元素移出滑动窗口
                set.remove(nums[i - k - 1]);
            }
            // add时，如果false 则说明滑动窗口中有重复元素了
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
