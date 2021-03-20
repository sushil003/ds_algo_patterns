package com.patterns.topkelements;

import java.util.*;

/**
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 * Example 1:
 * Input: [1, 3, 5, 12, 11, 12, 11], K = 2
 * Output: [12, 11]
 * Explanation: Both '11' and '12' appeared twice.
 * Time complexity : O(N + NLOG(K))
 * Space complexity : O(N)
 */
public class TopKFrequentNumbers {

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[]{1, 3, 5, 12, 11, 12, 11}, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[]{5, 12, 11, 3, 11}, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (int num : nums) {

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            queue.offer(entry);
            if (queue.size() > k) {

                queue.poll();
            }
        }

        while (topNumbers.size() < k) {

            topNumbers.add(queue.poll().getKey());
        }

        return topNumbers;
    }
}
