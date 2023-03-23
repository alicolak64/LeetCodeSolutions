package LeetCode.Medium;

public class AddTwoNumbers {

    /*

        You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.

        Example:

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.

    */

    // Link : https://leetcode.com/problems/add-two-numbers/

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode list = new ListNode(0);
        ListNode head = list;
        int remainder = 0;

        while (l1 != null || l2 != null) {

            int sum = remainder;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            head.next = new ListNode(sum % 10);
            head = head.next;
            remainder = sum / 10;

        }

        if (remainder != 0) {
            head.next = new ListNode(remainder);
        }

        return list.next;

    }

    public static class ListNode {

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
