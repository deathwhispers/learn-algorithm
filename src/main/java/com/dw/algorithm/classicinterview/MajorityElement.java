package com.dw.algorithm.classicinterview;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/10/14 9:11
 * @see <a href="https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150">多数元素</a>
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Map.Entry<Integer, Integer> result = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (result == null || entry.getValue() > result.getValue()) {
                result = entry;
            }
        }
        return result.getKey();
    }
}
