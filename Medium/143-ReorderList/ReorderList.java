public class ReorderList {

    /*

    You are given the head of a singly linked-list. The list can be represented as:

    L0 → L1 → … → Ln - 1 → Ln

    Reorder the list to be on the following form:

    L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

    You may not modify the values in the list's nodes. Only nodes themselves may be changed.

    Example 1:

    Input: head = [1,2,3,4]
    Output: [1,4,2,3]

    Example 2:

    Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]

    Constraints:

    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000

     */

     // Link : https://leetcode.com/problems/reorder-list/

        public static void main(String[] args) {
    
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
    
            reorderList(head);
    
        }

        public static void reorderList(ListNode head) {

            if (head == null || head.next == null)
                return;

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode prev = null;
            ListNode curr = slow;
            ListNode next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode first = head;
            ListNode second = prev;

            while (second.next != null) {
                next = first.next;
                first.next = second;
                first = next;

                next = second.next;
                second.next = first;
                second = next;
            }

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
    
            @Override
            public String toString() {
                return val + " -> " + next;
            }
    
        }
        
}