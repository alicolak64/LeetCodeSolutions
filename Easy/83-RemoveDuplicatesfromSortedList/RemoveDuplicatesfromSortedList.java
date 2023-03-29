public class RemoveDuplicatesfromSortedList {

    /*

    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

    Example 1:

    Input: head = [1,1,2]
    Output: [1,2]

    Example 2:

    Input: head = [1,1,2,3,3]
    Output: [1,2,3]

     */

    // Link : https://leetcode.com/problems/remove-duplicates-from-sorted-list/

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        ListNode result = deleteDuplicates(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {

            if (current.val == current.next.val)
                current.next = current.next.next;
            else
                current = current.next;

        }

        return head;

    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
