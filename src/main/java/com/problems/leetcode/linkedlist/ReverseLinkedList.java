package com.problems.leetcode.linkedlist;


public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    //Time complexity : O(n)O(n). Assume that nn is the list's length, the time complexity is O(n)O(n).
    //Space complexity : O(n)O(n). The extra space comes from implicit stack space due to recursion.
    //The recursion could go up to nn levels deep.
    public ListNode reverseListV1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp=reverseListV1(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
