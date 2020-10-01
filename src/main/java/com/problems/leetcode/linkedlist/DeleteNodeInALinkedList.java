package com.problems.leetcode.linkedlist;

public class DeleteNodeInALinkedList {

    public static void main(String[] args) {

    }

    //Time and space complexity are both O(1)O(1).
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
}
