package com.problems.leetcode.linkedlist;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoListsV1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }

        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }

        return head.next;
    }

    public static ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoListsV2(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoListsV2(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
