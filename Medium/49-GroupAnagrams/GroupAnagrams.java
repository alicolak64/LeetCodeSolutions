import java.util.*;

public class GroupAnagrams {

    /*

    Given an array of strings, group anagrams together.

    Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]

    Note:

    All inputs will be in lowercase.
    The order of your output does not matter.

     */

    // Link : https://leetcode.com/problems/group-anagrams/

    public static void main(String[] args) {


        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));


    }

    public static List<List<String>> groupAnagrams(String[] strings) {

        if (strings == null || strings.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> stringAnagramsMap = new HashMap<>();

        for (String s : strings) {

            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if (!stringAnagramsMap.containsKey(key))
                stringAnagramsMap.put(key, new ArrayList<>());

            stringAnagramsMap.get(key).add(s);

        }

        List<List<String>> resultList = new ArrayList<>();

        for (Map.Entry<String, List<String>> stringAnagrams : stringAnagramsMap.entrySet())
            resultList.add(stringAnagrams.getValue());

        return resultList;

    }

}
