import java.util.PriorityQueue;

public class KthLargestElementinaStream {

    /*

    Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Implement KthLargest class:

    KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.

    int add(int val) Returns the element representing the kth largest element in the stream.

    Example 1:

    Input
    ["KthLargest", "add", "add", "add", "add", "add"]
    [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
    Output
    [null, 4, 5, 5, 8, 8]
    Explanation
    KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
    kthLargest.add(3);   // return 4
    kthLargest.add(5);   // return 5
    kthLargest.add(10);  // return 5
    kthLargest.add(9);   // return 8
    kthLargest.add(4);   // return 8

     */

    // Link : https://leetcode.com/problems/kth-largest-element-in-a-stream/


    public static void main(String[] args) {

        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8

    }

    static class KthLargest {

        PriorityQueue<Integer> queue;
        int k;

        public KthLargest(int k, int[] nums) {

            this.k = k;
            queue = new PriorityQueue<>();

            for (int num : nums) {

                queue.add(num);

                if (queue.size() > k)
                    queue.poll();

            }
        }

        public int add(int val) {

            queue.add(val);

            if (queue.size() > k)
                queue.poll();

            return queue.peek();

        }

    }

}
