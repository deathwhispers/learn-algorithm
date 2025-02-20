package com.dw.algorithm.slidingwindow.fixedlength;

import java.util.HashMap;
import java.util.List;

/**
 * 几乎唯一子数组的最大和
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/2/11 11:40
 * <a href = "https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/">几乎唯一子数组的最大和</a>
 */
public class MaxSumOfAlmostUniqueSubarray {
    public static void main(String[] args) {
        MaxSumOfAlmostUniqueSubarray test = new MaxSumOfAlmostUniqueSubarray();
        List<Integer> nums = List.of(1, 1, 1, 3);
        long l = test.maxSum(nums, 2, 2);
        System.out.println(l);
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        if (n < k || m > k) {
            return 0;
        }
        long ans = 0;
        long sum = 0;
        // 要统计窗口中不同元素的数量
        // 不能用 set 因为如果窗口存在 n 个相同元素时，移除时会全部删掉, 但实际窗口内还应存在 n-1 个该元素
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 右侧元素移入，同时在 map 中记录该元素出现的次数
            Integer right = nums.get(i);
            sum += right;
            map.put(right, map.getOrDefault(right, 0) + 1);

            // 窗口长度不足 k 时，继续
            if (i < k - 1) {
                continue;
            }

            // 窗口中不同元素个数应超过 m 个，不足时，不计入结果
            if (map.size() >= m) {
                ans = Math.max(ans, sum);
            }
            // 左侧元素出窗口，元素和中减掉该元素
            Integer left = nums.get(i - k + 1);
            sum -= left;

            // 更新 map，若 map 中只有一个该元素，则删除 key，否则个数 -1
            Integer count = map.get(left);
            if (count == 1) {
                map.remove(left);
            } else {
                map.put(left, count - 1);
            }
        }
        return ans;
    }

}
