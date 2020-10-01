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

    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
