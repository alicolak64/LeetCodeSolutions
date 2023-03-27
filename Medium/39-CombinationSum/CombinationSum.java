import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /*

    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

    Example 1:

    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    7 is a candidate, and 7 = 7.
    These are the only two combinations.

    Example 2:

    Input: candidates = [2,3,5], target = 8
    Output: [[2,2,2,2],[2,3,3],[3,5]]

    Example 3:

    Input: candidates = [2], target = 1
    Output: []

    Example 4:

    Input: candidates = [1], target = 1
    Output: [[1]]

    Example 5:

    Input: candidates = [1], target = 2
    Output: [[1,1]]

     */

    // Link : https://leetcode.com/problems/combination-sum/

    public static void main(String[] args) {

        int[] candidates = {2,3,6,7};
        int target = 7;

        for (List<Integer> list : combinationSum(candidates, target))
            System.out.println(list);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        combinationSum(candidates, target, 0, temp, result);

        return result;

    }

    public static void combinationSum(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0)
            return;

        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, temp, result);
            temp.remove(temp.size() - 1);
        }

    }

}
