package com.dw.algorithm.classicinterview;

import java.util.HashMap;

/**
 * 两数之和 II - 输入有序数组
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/12/31 17:17
 * @see <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150">两数之和 II - 输入有序数组</a>
 */
public class TwoSumII {

    // 数组下标序号从 1 开始
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                }
            }
        }
        return result;
    }


    /**
     * 哈希表，空间换时间 key：数值，value：数组下标
     * 判断 目标数-当前数 是否仔哈希表中，若在，则有解，若不在，则将当前数及下标保存到哈希表中
     */
    public int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i + 1};
            }
            map.put(numbers[i], i + 1);
        }
        return new int[0];
    }

    // 双指针

    /**
     * 双指针：利用有序表的特性
     * 使用双指针的实质是缩小查找范围。那么会不会把可能的解过滤掉？
     * 答案是不会。假设 numbers[i] + numbers[j] = target 是唯一解，其中 0 ≤ i < j ≤ numbers.length−1。
     * 初始时两个指针分别指向下标 0 和下标 numbers.length−1，左指针指向的下标小于或等于 i，右指针指向的下标大于或等于 j。
     * 除非初始时左指针和右指针已经位于下标 i 和 j，否则一定是左指针先到达下标 i 的位置或者右指针先到达下标 j 的位置。
     * <p>
     * 如果左指针先到达下标 i 的位置，此时右指针还在下标 j 的右侧，sum > target，因此一定是右指针左移，左指针不可能移到 i 的右侧。
     * <p>
     * 如果右指针先到达下标 j 的位置，此时左指针还在下标 i 的左侧，sum < target，因此一定是左指针右移，右指针不可能移到 j 的左侧。
     */
    public int[] twoSum3(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum < target) {
                left++;
            }
            if (sum > target) {
                right--;
            }
        }
        return new int[0];
    }

}
