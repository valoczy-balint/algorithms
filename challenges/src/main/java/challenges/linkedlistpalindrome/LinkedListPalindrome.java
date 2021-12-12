package challenges.linkedlistpalindrome;

public class LinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode end = head;
        ListNode half = head;

        while (end.next != null) {
            if (end.next.next == null) {
                end = end.next;
            } else {
                end = end.next.next;
            }
            half = half.next;
        }

        reverse(half);

        while (end != null) {
            if (head.val != end.val) {
                return false;
            }
            end = end.next;
            head = head.next;
        }
        return true;
    }

    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;

        while(current != null) {
            current.next = prev;

            prev = current;
            current = next;
            if(next != null) {
                next = next.next;
            }
        }
    }
}
