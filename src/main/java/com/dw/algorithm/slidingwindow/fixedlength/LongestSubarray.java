package com.dw.algorithm.slidingwindow.fixedlength;

/**
 * <h1>删掉一个元素以后全为 1 的最长子数组</h1>
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/3/4 16:41
 */
public class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        int i = new LongestSubarray().longestSubarray(nums);
        System.out.println(i);
    }

    /**
     * 删掉一个元素以后全为 1 的最长子数组，其实就是只包含一个 0 的最长子数组
     * 取两个指针 left、right，保证窗口中只有一个 0 ，ans = right - left +1 -1
     */
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int left = 0;
        int n = nums.length;
        // 记录窗口中 0 的个数
        int count = 0;
        for (int right = 0; right < n; right++) {
            // 右侧元素进入窗口，记录窗口中 0 的个数
            if (nums[right] == 0) {
                count++;
            }
            // 当窗口中 0 的个数 >1 时，左侧元素离开窗口
            while (count > 1) {
                // 当左侧元素为 0 时，更新 count 值
                if (nums[left++] == 0) {
                    count--;
                }
            }
            // 更新结果
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
