public class MergeSortedArray {

    /*

    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

    Example 1:

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]

    Example 2:

    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]

     */

    // Link : https://leetcode.com/problems/merge-sorted-array/

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);

        for (int j : nums1) {
            System.out.println(j);
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int index = m + n - 1;

        while (nums1Index >= 0 && nums2Index >= 0) {

            if (nums1[nums1Index] > nums2[nums2Index])
                nums1[index--] = nums1[nums1Index--];
            else
                nums1[index--] = nums2[nums2Index--];

        }

        while (nums2Index >= 0)
            nums1[index--] = nums2[nums2Index--];


    }

}
