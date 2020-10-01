package com.problems.leetcode.linkedlist;


public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

    //Time complexity : O(L).
    //Space complexity : O(1).
    //Two pass algorithm
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int size=0;
        ListNode iterator=head;
        while(iterator!=null){
            iterator=head.next;
            ++size;
        }
        iterator=dummy;
        size -= n;
        while (size > 0) {
            size--;
            iterator = iterator.next;
        }
        iterator.next = iterator.next.next;
        return dummy.next;
    }

    //Time complexity : O(L)O(L).
    //The algorithm makes one traversal of the list of LL nodes. Therefore time complexity is O(L)O(L).
    //Space complexity : O(1)O(1).
    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
