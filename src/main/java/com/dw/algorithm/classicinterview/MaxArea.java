package com.dw.algorithm.classicinterview;

/**
 * 盛最多水的容器
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/2 9:40
 * @see <a href="https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150">盛最多水的容器</a>
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int temp = 0;
            if (height[left] <= height[right]) {
                temp = (right - left) * height[left];
                left++;
            } else if (height[right] < height[left]) {
                temp = (right - left) * height[right];
                right--;
            }
            maxArea = Math.max(maxArea, temp);
        }
        return maxArea;
    }

}
