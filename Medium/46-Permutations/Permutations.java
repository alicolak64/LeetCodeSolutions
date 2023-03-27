import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /*

    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

    Example 1:

    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    Example 2:

    Input: nums = [0,1]
    Output: [[0,1],[1,0]]

    Example 3:

    Input: nums = [1]
    Output: [[1]]

     */

    // Link : https://leetcode.com/problems/permutations/

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        for (List<Integer> list : permute(nums))
            System.out.println(list);

    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for (int number : nums) {

            List<List<Integer>> current = new ArrayList<>();

            for (List<Integer> list : result) {

                for (int j = 0; j < list.size() + 1; j++) {

                    list.add(j, number);
                    current.add(new ArrayList<>(list));
                    list.remove(j);

                }
            }

            result = new ArrayList<>(current);

        }

        return result;

    }

}
