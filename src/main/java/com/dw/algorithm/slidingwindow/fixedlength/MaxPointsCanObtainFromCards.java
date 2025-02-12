package com.dw.algorithm.slidingwindow.fixedlength;

/**
 * 可获得的最大点数
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * <p>
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * <p>
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * <p>
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/2/12 14:29
 * <a href = "https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/description/">可获得的最大点数</a>
 */
public class MaxPointsCanObtainFromCards {

    // 思路 1：由于每次拿牌只能从开头或者末尾拿牌
    // 因此，可以将数组想象成一个环，从 （n-k）到（n+k）% n 这一段中取出 k 张牌
    // 使用滑动窗口思想，取出这一段中连续的 k 张牌，使得点数最大
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        int n = cardPoints.length;
        if (k > n) {
            return ans;
        }
        int sum = 0;
        for (int i = n - k; i < n + k; i++) {
            // 左侧元素进入窗口
            sum += cardPoints[i % n];
            if (i < n - 1) {
                continue;
            }
            // 更新答案
            ans = Math.max(ans, sum);
            sum -= cardPoints[(i - k + 1) % n];
        }
        return ans;
    }

}
