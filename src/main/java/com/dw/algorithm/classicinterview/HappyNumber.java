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
public class HappyNumber {

    public int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int i = n % 10;
            n = n / 10;
            sum += i * i;
        }
        return sum;
    }

    // 方法一：用哈希集合检测循环
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 方法二：快慢指针法
     * 通过反复调用 getNext(n) 得到的链是一个隐式的链表。隐式意味着我们没有实际的链表节点和指针，但数据仍然形成链表结构。起始数字是链表的头 “节点”，链中的所有其他数字都是节点。next 指针是通过调用 getNext(n) 函数获得。
     * <p>
     * 意识到我们实际有个链表，那么这个问题就可以转换为检测一个链表是否有环。因此我们在这里可以使用弗洛伊德循环查找算法。这个算法是两个奔跑选手，一个跑的快，一个跑得慢。在龟兔赛跑的寓言中，跑的慢的称为 “乌龟”，跑得快的称为 “兔子”。
     * <p>
     * 不管乌龟和兔子在循环中从哪里开始，它们最终都会相遇。这是因为兔子每走一步就向乌龟靠近一个节点（在它们的移动方向上）。
     *
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

}
