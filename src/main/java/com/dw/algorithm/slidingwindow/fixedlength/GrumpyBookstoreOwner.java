package com.dw.algorithm.slidingwindow.fixedlength;

/**
 * 爱生气的书店老板
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/2/10 15:09
 * <a href = "https://leetcode.cn/problems/grumpy-bookstore-owner/description/">爱生气的书店老板</a>
 */
public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        int n = customers.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0)
                sum += customers[i];
        }
        for (int i = 0; i < n; i++) {
            // 右侧元素进入队列
            if (grumpy[i] == 1)
                sum += customers[i];
            if (i < minutes - 1)
                continue;

            // 更新值
            res = Math.max(res, sum);

            // 左侧元素出队列
            if (grumpy[i - minutes + 1] == 1)
                sum -= customers[i - minutes + 1];
        }
        return res;
    }

    public int maxSatisfied2(int[] customers, int[] grumpy, int minutes) {
        int[] s = new int[2];
        int maxS1 = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            // 右侧元素进入队列
            s[grumpy[i]] += customers[i];
            if (i < minutes - 1) {
                continue;
            }
            // 更新值
            maxS1 = Math.max(maxS1, s[1]);

            // 左侧元素出队列
            if (grumpy[i - minutes + 1] == 1)
                s[1] -= customers[i - minutes + 1];
        }
        return s[0] + maxS1;
    }

}
