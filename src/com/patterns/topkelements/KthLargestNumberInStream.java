package com.patterns.topkelements;

import java.util.PriorityQueue;

/**
 * Design a class to efficiently find the Kth largest element in a stream of numbers.
 * The class should have the following two things:
 * The constructor of the class should accept an integer array containing initial numbers from
 * the stream and an integer ‘K’.
 * The class should expose a function add(int num) which will store the given number and return
 * the Kth largest number.
 * Example 1:
 * Input: [3, 1, 5, 12, 2, 11], K = 4
 * 1. Calling add(6) should return '5'.
 * 2. Calling add(13) should return '6'.
 * 2. Calling add(4) should still return '6'.
 * Time complexity : O(LOG(K))
 * Space complexity : O(K)
 */
public class KthLargestNumberInStream {

    final int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

    public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;
        // add the numbers in the min heap
        for (int i = 0; i < nums.length; i++)
            add(nums[i]);
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 5, 12, 2, 11};
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }

    public int add(int num) {
        // add the new number in the min heap
        minHeap.add(num);

        // if heap has more than 'k' numbers, remove one number
        if (minHeap.size() > this.k)
            minHeap.poll();

        // return the 'Kth largest number
        return minHeap.peek();
    }
}
