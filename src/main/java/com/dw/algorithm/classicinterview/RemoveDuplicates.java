package com.dw.algorithm.classicinterview;

/**
 * 删除有序数组中的重复项
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/10/12 9:25
 * @see <a href= "https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150">删除有序数组中的重复项<a/>
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != nums[idx]) {
                nums[++idx] = num;
            }
        }
        return idx + 1;
    }
}
