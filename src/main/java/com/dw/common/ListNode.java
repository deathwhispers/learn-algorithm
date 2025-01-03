package com.dw.common;

/**
 * @author yanggj
 * @version 1.0.0
 * @date 2025/1/3 9:47
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
