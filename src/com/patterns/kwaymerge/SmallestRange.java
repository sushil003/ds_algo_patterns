package com.patterns.kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given ‘M’ sorted arrays, find the smallest range that includes at least one number from each of the ‘M’ lists.
 * Example 1:
 * Input: L1=[1, 5, 8], L2=[4, 12], L3=[7, 8, 10]
 * Output: [4, 7]
 * Explanation: The range [4, 7] includes 5 from L1, 4 from L2 and 7 from L3.
 * Time complexity : O(NLOG(M)) where ‘N’ is the total number of elements in all the ‘M’ input arrays.
 * Space complexity : O(M)
 */
public class SmallestRange {

    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{1, 5, 8};
        Integer[] l2 = new Integer[]{4, 12};
        Integer[] l3 = new Integer[]{7, 8, 10};
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }

    public static int[] findSmallestRange(List<Integer[]> lists) {
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {

            queue.offer(new Node(0, i));
            currentMax = Math.max(currentMax, lists.get(i)[0]);
        }

        while (queue.size() == lists.size()) {

            Node curr = queue.poll();

            if (rangeEnd - rangeStart > currentMax - lists.get(curr.arrayIndex)[curr.elementIndex]) {
                rangeStart = lists.get(curr.arrayIndex)[curr.elementIndex];
                rangeEnd = currentMax;
            }

            curr.elementIndex++;
            if (lists.get(curr.arrayIndex).length > curr.elementIndex) {
                queue.offer(curr);
                currentMax = Math.max(currentMax, lists.get(curr.arrayIndex)[curr.elementIndex]);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}
