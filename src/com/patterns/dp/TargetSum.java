package com.patterns.dp;

/**
 * You are given a set of positive numbers and a target sum ‘S’. Each number should be assigned either a ‘+’ or ‘-’
 * sign. We need to find the total ways to assign symbols to make the sum of the numbers equal to the target ‘S’.
 * Example 1: #
 * Input: {1, 1, 2, 3}, S=1
 * Output: 3
 * Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}
 * Time complexity :  O(N∗S) where ‘N’ represents total numbers and ‘S’ is the desired sum.
 * Space complexity : O(N∗S)
 */
public class TargetSum {

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }

    public int findTargetSubsets(int[] num, int s) {
        int totalSum = 0;
        for (int n : num)
            totalSum += n;

        // if 's + totalSum' is odd, we can't find a subset with sum equal to '(s + totalSum) / 2'
        if (totalSum < s || (s + totalSum) % 2 == 1)
            return 0;

        return countSubsets(num, (s + totalSum) / 2);
    }

    // this function is exactly similar to what we have in 'Count of Subset Sum' problem.
    private int countSubsets(int[] num, int sum) {
        int n = num.length;
        int[][] dp = new int[n][sum + 1];

        // populate the sum=0 columns, as we will always have an empty set for zero sum
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        // with only one number, we can form a subset only when the required sum is equal to the number
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? 1 : 0);
        }

        // process all subsets for all sums
        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                dp[i][s] = dp[i - 1][s];
                if (s >= num[i])
                    dp[i][s] += dp[i - 1][s - num[i]];
            }
        }
        // the bottom-right corner will have our answer.
        return dp[num.length - 1][sum];
    }
}
