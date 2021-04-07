package com.patterns.dp;

/**
 * Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items
 * which will give us maximum profit such that their cumulative weight is not more than a given number ‘C.’ Each
 * item can only be selected once, which means either we put an item in the knapsack or we skip it.
 * Time complexity :  O(N∗C) where ‘N’ represents total items, and ‘C’ is the maximum capacity.
 * Space complexity : O(N∗C)
 */
public class Knapsack {

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {

        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) {
            return 0;
        }

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {

            dp[i][0] = 0;
        }

        for (int c = 0; c <= capacity; c++) {

            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < n; i++) {

            for (int c = 1; c <= capacity; c++) {

                int profit1 = 0;
                int profit2 = 0;

                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }

                profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[n - 1][capacity];
    }
}
