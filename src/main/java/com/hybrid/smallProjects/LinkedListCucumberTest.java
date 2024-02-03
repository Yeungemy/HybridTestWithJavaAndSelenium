package com.hybrid.smallProjects;

import pages.ListNode;
import org.testng.annotations.Test;

public class LinkedListCucumberTest {
    @Test
    public void deleteNodeTest() {
        // Example 1: [4, 5, 1, 9], node = 5
        ListNode head1 = ListNode.createLinkedList(new int[]{4, 5, 1, 9});
        ListNode node1 = ListNode.findNode(head1, 5);
        ListNode.deleteNode(node1);
        ListNode.printLinkedList(head1);  // Output: [4, 1, 9]

        // Example 2: [4, 5, 1, 9], node = 1
        ListNode head2 = ListNode.createLinkedList(new int[]{4, 5, 1, 9});
        ListNode node2 = ListNode.findNode(head2, 1);
        ListNode.deleteNode(node2);
        ListNode.printLinkedList(head2);  // Output: [4, 5, 9]
    }
}
