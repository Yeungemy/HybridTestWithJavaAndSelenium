package com.hybridTest.unitTest.math;

import com.hybridTest.pages.ListNode;
import org.testng.annotations.Test;

import static com.hybridTest.pages.ListNode.*;

public class LinkedListCucumberTest {
    @Test
    public void deleteNodeTest() {
        // Example 1: [4, 5, 1, 9], node = 5
        ListNode head1 = createLinkedList(new int[]{4, 5, 1, 9});
        ListNode node1 = findNode(head1, 5);
        deleteNode(node1);
        printLinkedList(head1);  // Output: [4, 1, 9]

        // Example 2: [4, 5, 1, 9], node = 1
        ListNode head2 = createLinkedList(new int[]{4, 5, 1, 9});
        ListNode node2 = findNode(head2, 1);
        deleteNode(node2);
        printLinkedList(head2);  // Output: [4, 5, 9]
    }
}
