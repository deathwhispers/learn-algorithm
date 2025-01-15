package com.dw.algorithm.classicinterview;

import java.util.Arrays;

/**
 * H 指数
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/15 14:26
 * @see <a href="https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150">H 指数</a>
 */
public class HIndex {

    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int hIndex = 0;
        for (hIndex = 0; hIndex < n; hIndex++) {
            if (hIndex >= citations[n-hIndex-1]) {
                break;
            }
        }
        return hIndex;
    }
}
