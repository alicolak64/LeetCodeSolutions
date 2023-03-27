import java.util.PriorityQueue;

public class KthLargestElementinanArray {

    /*

    Given an integer array nums and an integer k, return the kth largest element in the array.

    Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Example 1:

    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5

    Example 2:

    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4

     */

    // Link : https://leetcode.com/problems/kth-largest-element-in-an-array/

    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));

    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue < Integer > queue = new PriorityQueue <> ();

        for (int num : nums) {

            queue.add(num);

            if (queue.size() > k)
                queue.poll();

        }

        return queue.poll();

    }


}
