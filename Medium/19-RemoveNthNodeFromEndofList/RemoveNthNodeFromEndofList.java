public class RemoveNthNodeFromEndofList {

    /*

        Given a linked list, remove the n-th node from the end of list and return its head.

        Example:
        Given linked list: 1->2->3->4->5, and n = 2.
        After removing the second node from the end, the linked list becomes 1->2->3->5.

        Note:
        Given n will always be valid.

        Follow up:
        Could you do this in one pass?

     */

    // Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(removeNthFromEnd(head, 2));

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = new ListNode(0);
        node.next = head;
        ListNode first = node;
        ListNode second = node;

        for (int i = 1; i <= n + 1; i++)
            first = first.next;

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return node.next;

    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
