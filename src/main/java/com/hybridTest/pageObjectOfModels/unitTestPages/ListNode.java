package com.hybridTest.pageObjectOfModels.unitTestPages;

public class ListNode {
    int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Invalid node");
        }

        // Copy the value of the next node to the given node
        node.val = node.next.val;
        // Skip the next node
        node.next = node.next.next;
    }

    public static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    public static ListNode findNode(ListNode head, int value) {
        ListNode current = head;

        while (current != null && current.val != value) {
            current = current.next;
        }

        return current;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
