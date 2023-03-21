public class DailyTemperatures {

    /*

    Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

    Example 1:

    Input: temperatures = [73,74,75,71,69,72,76,73]
    Output: [1,1,4,2,1,1,0,0]

    Example 2:

    Input: temperatures = [30,40,50,60]
    Output: [1,1,1,0]

    Example 3:

    Input: temperatures = [30,60,90]
    Output: [1,1,0]

     */

    // Link : https://leetcode.com/problems/daily-temperatures/

    public static void main(String[] args) {

        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = new DailyTemperatures().dailyTemperatures(temperatures);

        for (int i : result)
            System.out.print(i + " ");

    }

    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        int[] stack = new int[temperatures.length];
        int top = -1;

        for (int i = 0; i < temperatures.length; i++) {

            while(top != -1 && temperatures[stack[top]] < temperatures[i]){
                result[stack[top]] = i - stack[top];
                top--;
            }

            stack[++top] = i;

        }

        return result;

    }

}
