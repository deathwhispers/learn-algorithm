package com.dw.algorithm.classicinterview;

/**
 * 删除有序数组中的重复项 II
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/10/12 9:32
 * @see <a href= "https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150">删除有序数组中的重复项 II<a/>
 */
public class removeDuplicates2 {

    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    int process(int[] nums, int k) {
        int n = nums.length;
        // 记录新数组的下标，直接从k开始
        int i = k;
        // j 指针遍历数组
        for (int j = k; j < n; j++) {
            // 当前元素和前k个元素不同时，则保留
            if (nums[i - k] != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
