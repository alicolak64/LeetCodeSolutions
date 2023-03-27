import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*

    Given an integer array nums of unique elements, return all possible subsets (the power set).

    The solution set must not contain duplicate subsets. Return the solution in any order.

    Example 1:

    Input: nums = [1,2,3]
    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    Example 2:

    Input: nums = [0]
    Output: [[],[0]]

     */

    // Link : https://leetcode.com/problems/subsets/

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        
        for (List<Integer> list : subsets(nums)) 
            System.out.println(list);
        
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {

            int size = result.size();

            for (int i = 0; i < size; i++) {

                List<Integer> list = new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);

            }

        }

        return result;

    }

}
