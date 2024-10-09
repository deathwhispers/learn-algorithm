package com.dw.algorithm.classicinterview;

/**
 * 合并两个有序数组
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/10/9 17:53
 * @see <a href="https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150">合并两个有序数组</a>
 */
public class Merge2SortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // nums1的最后一个有效元素的下标
        int j = n - 1; // nums2的最后一个元素的下标
        int k = m + n - 1; // 合并后nums1的最后一个位置的下标

        // 从后往前合并
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // 如果nums2还有剩余元素，继续填充到nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}