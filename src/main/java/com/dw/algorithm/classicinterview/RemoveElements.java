package com.dw.algorithm.classicinterview;

/**
 * 移除元素
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2024/10/11 9:47
 * @see <a href="https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150">移除元素</a>
 */
public class RemoveElements {

    /**
     * 先设定变量 flag，指向待插入位置。flag 初始值为 0
     * <p>
     * 然后从题目的「要求/保留逻辑」出发，来决定当遍历到任意元素 x 时，应该做何种决策：
     * <p>
     * 如果当前元素 x 与移除元素 val 相同，那么跳过该元素。
     * 如果当前元素 x 与移除元素 val 不同，那么我们将其放到下标 flag 的位置，并让 flag 自增右移。
     * 最终得到的 flag 即是答案。
     */
    public int removeElement(int[] nums, int val) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[flag++] = nums[i];
            }
        }
        return flag;
    }


    /**
     * 根据题意，我们可以将数组分成「前后」两段：
     * <p>
     * 前半段是有效部分，存储的是不等于 val 的元素。
     * 后半段是无效部分，存储的是等于 val 的元素。
     * 最终答案返回有效部分的结尾下标。
     */
    public int removeElement2(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val) {
                swap(nums, i--, j--);
            }
        }
        return j + 1;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
