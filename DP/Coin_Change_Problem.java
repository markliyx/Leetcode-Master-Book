class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minNum = new int[amount+1];
        int tgt = coinChangeRecursion(coins, amount, minNum);
        if (tgt == -1) return -1;
        return tgt - 1;
    }
    
    public int coinChangeRecursion(int[] coins, int amount, int[] minNum) {
        if (amount == 0) return 1;
        else if (amount < 0 || minNum[amount] == -1) return -1;
        else if (minNum[amount] > 0) return minNum[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int times = coinChangeRecursion(coins, amount - coin, minNum);
            if (times < min && times != -1) min = times;
        } 
        if (min == Integer.MAX_VALUE) {
            minNum[amount] = -1;
            return -1;
        }
        minNum[amount] = min + 1;
        return minNum[amount];
    }
}

/*
322. Coin Change
Medium

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/ 