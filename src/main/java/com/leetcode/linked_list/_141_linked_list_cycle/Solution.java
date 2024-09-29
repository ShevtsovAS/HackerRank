package com.leetcode.linked_list._141_linked_list_cycle;

/**
 * <h1>141. Linked List Cycle</h1>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.<br>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.<br>
 * Return true if there is a cycle in the linked list. Otherwise, return false.<br>
 * <br>
 * Example 1:<br>
 * Input: head = [3,2,0,-4], pos = 1<br>
 * Output: true<br>
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).<br>
 * <br>
 * Example 2:<br>
 * Input: head = [1,2], pos = 0<br>
 * Output: true<br>
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.<br>
 * <br>
 * Example 3:<br>
 * Input: head = [1], pos = -1<br>
 * Output: false<br>
 * Explanation: There is no cycle in the linked list.<br>
 * <br>
 * Constraints:<br>
 * The number of the nodes in the list is in the range [0, 104].<br>
 * -10^5 <= Node.val <= 10^5<br>
 * pos is -1 or a valid index in the linked-list.<br>
 * <br>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?<br>
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode node2 = head.next.next;
        return hasCycle(head, node2);
    }

    public boolean hasCycle(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) return false;
        if (node1 == node2) return true;
        return hasCycle(node1.next, node2.next != null ? node2.next.next : null);
    }

    public static void main(String[] args) {
        ListNode cyclePos = new ListNode(2);
        ListNode head = new ListNode(3);
        head
                .setNext(cyclePos)
                .setNext(new ListNode(0))
                .setNext(new ListNode(-4))
                .setNext(cyclePos);
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head));

        head = new ListNode(1);
        head
                .setNext(new ListNode(2))
                .setNext(head);
        System.out.println(solution.hasCycle(head));

        head = new ListNode(1);
        System.out.println(solution.hasCycle(head));
    }

}
