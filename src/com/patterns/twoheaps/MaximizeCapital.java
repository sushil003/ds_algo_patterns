package com.patterns.twoheaps;

import java.util.PriorityQueue;

/**
 * Given a set of investment projects with their respective profits, we need to find the most profitable
 * projects. We are given an initial capital and are allowed to invest only in a fixed number of projects.
 * Our goal is to choose projects that give us the maximum profit. Write a function that returns the
 * maximum total capital after selecting the most profitable projects.
 * Example 1:
 * Input: Project Capitals=[0,1,2], Project Profits=[1,2,3], Initial Capital=1, Number of Projects=2
 * Output: 6
 * Time complexity : O(NLOG(N)+KLOG(N))
 * Space complexity : O(N)
 */
public class MaximizeCapital {

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[]{0, 1, 2}, new int[]{1, 2, 3}, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 5}, 3, 0);
        System.out.println("Maximum capital: " + result);
    }

    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int n = profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(i);
        }

        int availableCapital = initialCapital;

        for (int i = 0; i < numberOfProjects; i++) {

            while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            availableCapital += profits[maxProfitHeap.poll()];

        }

        return availableCapital;
    }
}
