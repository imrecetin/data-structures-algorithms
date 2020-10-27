package com.problems.leetcode.easy.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    //Time complexity : O(n)O(n). We visit each of the nn elements in the list at most once.
    //  Adding a node to the hash table costs only O(1)O(1) time.
    //Space complexity: O(n)O(n). The space depends on the number of elements added to the hash table,
    //  which contains at most nn elements.
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    //Space complexity : O(1)O(1). We only use two nodes (slow and fast) so the space complexity is O(1)O(1).
    //Time complexity : O(n)O(n). Let us denote nn as the total number of nodes in the linked list.
    public boolean hasCycleV2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
