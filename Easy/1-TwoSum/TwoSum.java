import java.util.HashMap;

public class TwoSum {

    /*

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]


    Follow up: Can you come up with an algorithm that is less than O(n2) time complexity?

     */

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        for (int i : twoSum(nums, target))
            System.out.print(i + " ");

    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap <Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};

            map.put(nums[i], i);

        }

        return new int[] {-1, -1};

    }

}