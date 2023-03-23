public class CopyListwithRandomPointer {

    /*

        A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
        Return a deep copy of the list.

        Example 1:
        Input:
        {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

        Explanation:
        Node 1's value is 1, both of its next and random pointer points to Node 2.
        Node 2's value is 2, its next pointer points to null and its random pointer points to itself.

        Note:
        You must return the copy of the given head as a reference to the cloned list.

     */

    // Link : https://leetcode.com/problems/copy-list-with-random-pointer/

    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        node.random = node.next.next;
        node.next.random = node.next.next.next.next;
        node.next.next.random = node.next.next.next;
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node.next;

        System.out.println(copyRandomList(node));

    }

    public static Node copyRandomList(Node head) {

        if (head == null)
            return null;

        Node node = head;

        while (node != null) {

            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;

        }

        node = head;

        while (node != null) {

            if (node.random != null)
                node.next.random = node.random.next;

            node = node.next.next;

        }

        Node newHead = head.next;
        Node newHeadNode = newHead;
        node = head;

        while (node != null) {

            node.next = node.next.next;

            assert newHeadNode != null;
            if (newHeadNode.next != null)
                newHeadNode.next = newHeadNode.next.next;

            node = node.next;
            newHeadNode = newHeadNode.next;

        }

        return newHead;

    }

    static class Node {

        int val;
        Node next;
        Node random;

        Node(int x) {
            val = x;
        }

    }


}
