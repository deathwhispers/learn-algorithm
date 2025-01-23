package com.dw.algorithm.slidingwindow.fixedlength;

/**
 * 大小为 K 且平均值大于等于阈值的子数组数目
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/23 16:22
 * <a href="https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/">大小为 K 且平均值大于等于阈值的子数组数目</a>
 */
public class NumOfSubarrays {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i - k + 1 < 0) {
                continue;
            }
            if (sum >= threshold * k) {
                ans++;
            }
            sum -= arr[i - k + 1];
        }
        return ans;
    }

    public int numOfSubarrays2(int[] arr, int k, int threshold) {
        int n = arr.length;
        int ans = 0;
        int sum = 0;
        int i = 0;
        for (; i < k - 1; i++) {
            sum += arr[i];
        }
        while (i < n) {
            sum += arr[i];
            if (sum >= threshold * k) {
                ans++;
            }
            sum -= arr[i - k + 1];
            i++;
        }
        return ans;
    }
}
