public class LinkedListCycle {

    /*

    Given head, the head of a linked list, determine if the linked list has a cycle in it.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
    Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
    Note that pos is not passed as a parameter.

    Return true if there is a cycle in the linked list. Otherwise, return false.

    Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

    Example 2:

    Input: head = [1,2], pos = 0
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

    Example 3:

    Input: head = [1], pos = -1
    Output: false
    Explanation: There is no cycle in the linked list.

     */

    public static void main(String[] args) {

        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = node.next;

        System.out.println(hasCycle(node));

    }

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;

        ListNode first = head;
        ListNode second = head;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;

            if (first == second)
                return true;
        }

        return false;

    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
