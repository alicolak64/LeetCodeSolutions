public class MedianofTwoSortedArrays {

    /*

        There are two sorted arrays nums1 and nums2 of size m and n respectively.
        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
        You may assume nums1 and nums2 cannot be both empty.

        Example 1:
        nums1 = [1, 3]
        nums2 = [2]

        The median is 2.0

        Example 2:
        nums1 = [1, 2]
        nums2 = [3, 4]

        The median is (2 + 3)/2 = 2.5

     */

    // Link : https://leetcode.com/problems/median-of-two-sorted-arrays/

    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }

            k++;

        }

        while (i < nums1.length) {
            nums[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            nums[k] = nums2[j];
            j++;
            k++;
        }

        if (nums.length % 2 == 0)
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        else
            return nums[nums.length / 2];


    }

}
