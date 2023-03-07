import java.util.*;

public class TopKFrequentElements {

    /*
    
    Given a non-empty array of integers, return the k most frequent elements.
    
    Example 1:
    
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
    
    Example 2:
    
    Input: nums = [1], k = 1
    Output: [1]
    
    Note:
    
    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    
     */
    
    // Link : https://leetcode.com/problems/top-k-frequent-elements/

    public static void main(String[] args) {

        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));

    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        int[] result = new int[k];

        for (int i = 0; i < k; i++)
            result[i] = list.get(i);

        return result;

    }

}
