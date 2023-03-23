import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /*
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

    The cache is initialized with a positive capacity.

    Follow up:
    Could you do both operations in O(1) time complexity?

    Example:

    LRUCache cache = new LRUCache( 2 );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4

    */

    // Link : https://leetcode.com/problems/lru-cache/

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }

    static class Node {

        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

    }

    public int get(int key) {

        if (map.containsKey(key)) {

            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;

        }

        return -1;

    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);

        } else {

            Node node = new Node(key, value);

            if (map.size() >= capacity) {

                map.remove(tail.key);
                remove(tail);

            }

            setHead(node);
            map.put(key, node);

        }

    }

    private void remove(Node node) {

        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;

    }

    private void setHead(Node node) {

        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        head = node;

        if (tail == null)
            tail = head;

    }

}
