package com.dw.algorithm.classicinterview;

import com.dw.common.ListNode;

import java.util.HashSet;

/**
 * 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/3 9:34
 * @see <a href="https://leetcode.cn/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-interview-150">环形链表</a>
 */
public class HasCycle {

    /**
     * 哈希表
     * 判断是否有重复元素
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针判断是否存在环
     * 慢指针每次走一步，快指针每次走两步
     */
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
