package com.dw.algorithm.classicinterview;

import com.dw.common.ListNode;

import java.util.HashSet;

/**
 * 环形链表 II
 *
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/3 10:15
 * @see <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">环形链表 II</a>
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 快慢指针
     * 假设起点到入环点 A 距离为 a ，快慢指针在环内相遇的位置 B ，入环点 A 到环中 B 的距离为 b ，B到 A 的距离为 c
     * 则有 快指针走的距离： a + n(b+c) + b ，慢指针走的距离为 a + b，则有 a + n(b+c) + b = 2(a+b)，可知 a = (n-1)(b+c)+c
     * 即对于一个慢指针从头走完a到达入环点A时,另一个慢指针可以从相遇点B走完c到达入环点(额外需要走过>=0圈)
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 此时，快慢指针相遇
            if (slow == fast) {
                // 此时，快慢指针相遇，定义一个慢指针从头开始
                ListNode temp = head;
                // 当两指针相遇时，即为入环点
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        // 跳出循环，意味着无环，快指针先一步走完
        return null;
    }
}
