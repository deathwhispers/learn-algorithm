package com.dw.algorithm.classicinterview;

import com.dw.common.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/3 10:15
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
