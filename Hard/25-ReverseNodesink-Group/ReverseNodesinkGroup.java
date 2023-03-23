public class ReverseNodesinkGroup {

        /*
        Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

        k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

        Example:

        Given this linked list: 1->2->3->4->5

        For k = 2, you should return: 2->1->4->3->5

        For k = 3, you should return: 3->2->1->4->5

        Note:

        Only constant extra memory is allowed.
        You may not alter the values in the list's nodes, only nodes itself may be changed.

        */

        // Link : https://leetcode.com/problems/reverse-nodes-in-k-group/

        public static void main(String[] args) {

            ListNode node = new ListNode(1);
            node.next = new ListNode(2);
            node.next.next = new ListNode(3);
            node.next.next.next = new ListNode(4);
            node.next.next.next.next = new ListNode(5);

            System.out.println(reverseKGroup(node, 2));

        }

        public static ListNode reverseKGroup(ListNode head, int k) {

            if (head == null || head.next == null || k == 1)
                return head;

            ListNode node = new ListNode(0);
            node.next = head;

            ListNode prev = node;
            ListNode curr = head;

            int count = 0;

            while (curr != null) {

                count++;
                curr = curr.next;

                if (count == k) {

                    prev = reverse(prev, curr);
                    count = 0;

                }

            }

            return node.next;

        }

        private static ListNode reverse(ListNode prev, ListNode next) {

            ListNode last = prev.next;
            ListNode curr = last.next;

            while (curr != next) {

                last.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
                curr = last.next;

            }

            return last;

        }

        static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }

            @Override
            public String toString() {
                return val + " -> " + next;
            }
        }

}
