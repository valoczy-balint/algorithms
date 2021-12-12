package challenges.linkedlistpalindrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListPalindromeTest {
    LinkedListPalindrome linkedListPalindrome = new LinkedListPalindrome();

    @org.junit.jupiter.api.Test
    public void test1() {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);

        assertFalse(linkedListPalindrome.isPalindrome(node1));
    }

    @org.junit.jupiter.api.Test
    public void test2() {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        assertTrue(linkedListPalindrome.isPalindrome(node1));
    }
}
