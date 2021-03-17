package com.patterns.topkelements;

import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find Kth smallest number in it.
 * Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.
 * Note: For a detailed discussion about different approaches to solve this problem, take a look
 * at Kth Smallest Number.
 * Example 1:
 * Input: [1, 5, 12, 2, 11, 5], K = 3
 * Output: 5
 * Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].
 * Time complexity : O(NLOG(K))
 * Space complexity : O(K)
 */
public class KthSmallestNumber {

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[]{5, 12, 11, -1, 12}, 3);
        System.out.println("Kth smallest number is: " + result);
    }

    public static int findKthSmallestNumber(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {

            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
