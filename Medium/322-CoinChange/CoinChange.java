import java.util.Arrays;

public class CoinChange {

    /*
    You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
    Example 1:
    coins = [1, 2, 5], amount = 11
    return 3 (11 = 5 + 5 + 1)
    Example 2:
    coins = [2], amount = 3
    return -1.
    Note:
    You may assume that you have an infinite number of each kind of coin.
     */

    // Link : https://leetcode.com/problems/coin-change/

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

    }

    public static int coinChange(int[] coins, int amount) {

        int[] minExchanges = new int[amount + 1];

        Arrays.fill(minExchanges, amount + 1);
        minExchanges[0] = 0;

        for (int i = 1; i <= amount; i++)
            for (int coin : coins)
                if (coin <= i)
                    minExchanges[i] = Math.min(minExchanges[i], minExchanges[i - coin] + 1);

        return minExchanges[amount] == amount + 1 ? -1 : minExchanges[amount];

    }

}
