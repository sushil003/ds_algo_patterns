package com.patterns.topkelements;

import java.util.PriorityQueue;

/**
 * Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with
 * minimum cost. The cost of connecting two ropes is equal to the sum of their lengths.
 * Example 1:
 * Input: [1, 3, 11, 5]
 * Output: 33
 * Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is
 * 33 (4+9+20)
 * Time complexity : O(NLOG(N))
 * Space complexity : O(N)
 */
public class ConnectRopes {

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[]{1, 3, 11, 5});
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[]{3, 4, 5, 6});
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[]{1, 3, 11, 5, 2});
        System.out.println("Minimum cost to connect ropes: " + result);
    }

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        // add all ropes to the min heap
        for (int i = 0; i < ropeLengths.length; i++)
            minHeap.add(ropeLengths[i]);

        // go through the values of the heap, in each step take top (lowest) rope lengths from the min heap
        // connect them and push the result back to the min heap.
        // keep doing this until the heap is left with only one rope
        int result = 0, temp = 0;
        while (minHeap.size() > 1) {
            temp = minHeap.poll() + minHeap.poll();
            result += temp;
            minHeap.add(temp);
        }

        return result;
    }
}
