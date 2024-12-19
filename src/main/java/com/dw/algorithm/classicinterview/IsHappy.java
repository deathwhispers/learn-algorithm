package com.dw.algorithm.classicinterview;

import java.util.HashSet;

/**
 * 快乐数
 * 根据我们的探索，我们猜测会有以下三种可能。
 * <p>
 * 最终会得到 1。
 * 最终会进入循环。
 * 值会越来越大，最后接近无穷大。
 * 第三个情况比较难以检测和处理。我们怎么知道它会继续变大，而不是最终得到 1 呢？我们可以仔细想一想，每一位数的最大数字的下一位数是多少。
 * <p>
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/12/18 17:45
 * @see <a href="https://leetcode.cn/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150">快乐数</a>
 */
public class IsHappy {

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(19));
        System.out.println(isHappy.isHappy(2));
        System.out.println(isHappy.isHappy(4));
        System.out.println(isHappy.isHappy(22));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int i = n % 10;
            n = n / 10;
            sum += i * i;
        }
        return sum;
    }

}
