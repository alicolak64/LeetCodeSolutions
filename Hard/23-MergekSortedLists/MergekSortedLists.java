public class MergekSortedLists {

    /*

        Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

        Example:

        Input:
        [
          1->4->5,
          1->3->4,
          2->6
        ]
        Output: 1->1->2->3->4->4->5->6

     */

    // Link : https://leetcode.com/problems/merge-k-sorted-lists/

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        System.out.println(mergeKLists(lists));

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;

        return merge(lists, 0, lists.length - 1);

    }

    public static ListNode merge(ListNode[] lists, int start, int end) {

        if (start == end)
            return lists[start];

        int mid = (start + end) / 2;

        ListNode l1 = merge(lists, start, mid);
        ListNode l2 = merge(lists, mid + 1, end);

        return mergeTwoLists(l1, l2);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode parent = head;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                parent.next = l1;
                l1 = l1.next;
            } else {
                parent.next = l2;
                l2 = l2.next;
            }

            parent = parent.next;

        }

        if (l1 != null)
            parent.next = l1;

        if (l2 != null)
            parent.next = l2;

        return head.next;

    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
