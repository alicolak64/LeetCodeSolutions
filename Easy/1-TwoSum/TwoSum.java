import java.util.Arrays;
public class TwoSum {

    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // Example:
    // Given nums = [2, 7, 11, 15], target = 9,
    // Because nums[0] + nums[1] = 2 + 7 = 9,
    // return [0, 1].

    // Link : https://leetcode.com/problems/two-sum/

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] numbers = Arrays.copyOf(nums, nums.length);

        Arrays.sort(numbers);

        int[] indexArray = {-1, -1};

        out:
        for (int i = 0; i < numbers.length; i++) {
            in:
            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] + numbers[j] > target)
                    break in;
                else if (numbers[i] + numbers[j] == target) {
                    indexArray[0] = numbers[i];
                    indexArray[1] = numbers[j];
                    break out;
                }

            }

        }


        if (indexArray[0] == indexArray[1]) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == indexArray[0]) {
                    indexArray[0] = i;
                    break;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == indexArray[1]) {
                    indexArray[1] = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == indexArray[0]) {
                    indexArray[0] = i;
                    break;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == indexArray[1]) {
                    indexArray[1] = i;
                    break;
                }
            }
        }

        Arrays.sort(indexArray);

        return indexArray;


    }

}
