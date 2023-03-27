import java.util.PriorityQueue;

public class FindMedianfromDataStream {

    /*

    Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

    For example,

    [2,3,4], the median is 3

    [2,3], the median is (2 + 3) / 2 = 2.5

    Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.


    Example:

    addNum(1)
    addNum(2)
    findMedian() -> 1.5
    addNum(3)
    findMedian() -> 2

    Follow up:

    If all integer numbers from the stream are between 0 and 100, how would you optimize it?
    If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

     */

    // Link : https://leetcode.com/problems/find-median-from-data-stream/

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // -> 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // -> 2

    }

    static class MedianFinder {

        PriorityQueue < Integer > minHeap;
        PriorityQueue < Integer > maxHeap;

        public MedianFinder() {

            minHeap = new PriorityQueue <> ();
            maxHeap = new PriorityQueue <> ((a, b) -> b - a);

        }

        public void addNum(int num) {

            maxHeap.add(num);
            minHeap.add(maxHeap.poll());

            if (maxHeap.size() < minHeap.size())
                maxHeap.add(minHeap.poll());

        }

        public double findMedian() {

            if (maxHeap.size() == minHeap.size())
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            else
                return maxHeap.peek();

        }

    }

}
