package com.patterns.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
 * Note: For a detailed discussion about different approaches to solve this problem, take a look
 * at Kth Smallest Number.
 * Example 1:
 * Input: [3, 1, 5, 12, 2, 11], K = 3
 * Output: [5, 12, 11]
 * Time complexity : O(NLOG(K))
 * Space complexity : O(K)
 */
public class KLargestNumbers {

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[]{3, 1, 5, 12, 2, 11}, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[]{5, 12, 11, -1, 12}, 3);
        System.out.println("Here are the top K numbers: " + result);
    }

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {

            queue.offer(num);
            if (queue.size() > k) {

                queue.poll();
            }
        }
        return new ArrayList<>(queue);
    }
}
