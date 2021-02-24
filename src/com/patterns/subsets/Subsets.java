package com.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set with distinct elements, find all of its distinct subsets.
 * Input: [1, 3]
 * Output: [], [1], [3], [1,3]
 * Time complexity : O(N*2^N)
 * Space complexity : O(N*2^N)
 */
public class Subsets {

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[]{1, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[]{1, 5, 3});
        System.out.println("Here is the list of subsets: " + result);
    }

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        for (int num : nums) {

            int n = subsets.size();
            for (int i = 0; i < n; i++) {

                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(num);
                subsets.add(set);
            }
        }
        return subsets;
    }
}
