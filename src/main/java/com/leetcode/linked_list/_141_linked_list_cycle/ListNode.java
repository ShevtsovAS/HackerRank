package com.leetcode.linked_list._141_linked_list_cycle;

import lombok.ToString;

@ToString(exclude = "next")
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return next;
    }
}
