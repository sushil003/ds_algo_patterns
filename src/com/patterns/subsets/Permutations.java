package com.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct numbers, find all of its permutations.
 * Example 1:
 * Input: [1,3,5]
 * Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 * Time complexity : O(N*N!)
 * Space complexity : O(N*N!)
 */
public class Permutations {

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.generatePermutations(new int[]{1, 3, 5});
        System.out.print("Here are all the permutations: " + result);
    }

    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsRecursive(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generatePermutationsRecursive(int[] nums, int index, List<Integer> currentPermutation,
                                                      List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(currentPermutation);
        } else {
            // create a new permutation by adding the current number at every position
            for (int i = 0; i <= currentPermutation.size(); i++) {
                List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
                newPermutation.add(i, nums[index]);
                generatePermutationsRecursive(nums, index + 1, newPermutation, result);
            }
        }
    }
}
